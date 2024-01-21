package com.github.damontecres.stashapp.data

import android.os.Parcelable
import com.github.damontecres.stashapp.api.fragment.SlimSceneData
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class Scene(
    val id: Long,
    val title: String?,
    val details: String?,
    val streamUrl: String?,
    val screenshotUrl: String?,
    val studioId: String?,
    val studioName: String?,
    val streams: Map<String, String>,
    val duration: Double?,
    val resumeTime: Double?,
) : Parcelable {
    companion object {
        fun fromSlimSceneData(data: SlimSceneData): Scene {
            val streams =
                data.sceneStreams
                    .filter { it.label != null }.associate {
                        Pair(it.label.toString(), it.url)
                    }
            val title =
                if (data.title.isNullOrBlank()) {
                    val path = data.files.firstOrNull()?.videoFileData?.path
                    if (path != null) {
                        File(path).name
                    } else {
                        null
                    }
                } else {
                    data.title
                }
            val duration = data.files.firstOrNull()?.videoFileData?.duration
            return Scene(
                id = data.id.toLong(),
                title = title,
                details = data.details,
                streamUrl = data.paths.stream,
                screenshotUrl = data.paths.screenshot,
                studioId = data.studio?.id,
                studioName = data.studio?.name,
                streams = streams,
                duration = duration,
                resumeTime = data.resume_time,
            )
        }
    }
}
