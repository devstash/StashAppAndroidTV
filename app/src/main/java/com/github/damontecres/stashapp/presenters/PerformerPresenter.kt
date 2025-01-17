package com.github.damontecres.stashapp.presenters

import android.os.Build
import androidx.leanback.widget.ImageCardView
import com.bumptech.glide.Glide
import com.github.damontecres.stashapp.R
import com.github.damontecres.stashapp.api.fragment.PerformerData
import com.github.damontecres.stashapp.data.DataType
import com.github.damontecres.stashapp.util.ageInYears
import com.github.damontecres.stashapp.util.createGlideUrl
import java.util.EnumMap

class PerformerPresenter(callback: LongClickCallBack<PerformerData>? = null) :
    StashPresenter<PerformerData>(callback) {
    override fun doOnBindViewHolder(
        cardView: ImageCardView,
        item: PerformerData,
    ) {
        if (item.image_path != null) {
            val title =
                item.name + (if (!item.disambiguation.isNullOrBlank()) " (${item.disambiguation})" else "")
            cardView.titleText = title

            if (item.birthdate != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val yearsOldStr = cardView.context.getString(R.string.stashapp_years_old)
                cardView.contentText = "${item.ageInYears} $yearsOldStr"
            }

            val dataTypeMap = EnumMap<DataType, Int>(DataType::class.java)
            dataTypeMap[DataType.SCENE] = item.scene_count

            setUpExtraRow(cardView, dataTypeMap, item.o_counter)

            cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)
            val url = createGlideUrl(item.image_path, cardView.context)
            Glide.with(cardView.context)
                .load(url)
                .centerCrop()
                .error(mDefaultCardImage)
                .into(cardView.mainImageView!!)
        }
    }

    companion object {
        private const val TAG = "CardPresenter"

        const val CARD_HEIGHT = 381
        const val CARD_WIDTH = CARD_HEIGHT * 2 / 3
    }
}
