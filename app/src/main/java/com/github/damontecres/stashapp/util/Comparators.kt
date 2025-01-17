package com.github.damontecres.stashapp.util

import androidx.recyclerview.widget.DiffUtil
import com.github.damontecres.stashapp.api.fragment.MarkerData
import com.github.damontecres.stashapp.api.fragment.MovieData
import com.github.damontecres.stashapp.api.fragment.PerformerData
import com.github.damontecres.stashapp.api.fragment.SlimSceneData
import com.github.damontecres.stashapp.api.fragment.StudioData
import com.github.damontecres.stashapp.api.fragment.TagData

object SceneComparator : DiffUtil.ItemCallback<SlimSceneData>() {
    override fun areItemsTheSame(
        oldItem: SlimSceneData,
        newItem: SlimSceneData,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: SlimSceneData,
        newItem: SlimSceneData,
    ): Boolean {
        return oldItem == newItem
    }
}

object PerformerComparator : DiffUtil.ItemCallback<PerformerData>() {
    override fun areItemsTheSame(
        oldItem: PerformerData,
        newItem: PerformerData,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PerformerData,
        newItem: PerformerData,
    ): Boolean {
        return oldItem == newItem
    }
}

object StudioComparator : DiffUtil.ItemCallback<StudioData>() {
    override fun areItemsTheSame(
        oldItem: StudioData,
        newItem: StudioData,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: StudioData,
        newItem: StudioData,
    ): Boolean {
        return oldItem == newItem
    }
}

object TagComparator : DiffUtil.ItemCallback<TagData>() {
    override fun areItemsTheSame(
        oldItem: TagData,
        newItem: TagData,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: TagData,
        newItem: TagData,
    ): Boolean {
        return oldItem == newItem
    }
}

object MovieComparator : DiffUtil.ItemCallback<MovieData>() {
    override fun areItemsTheSame(
        oldItem: MovieData,
        newItem: MovieData,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MovieData,
        newItem: MovieData,
    ): Boolean {
        return oldItem == newItem
    }
}

object MarkerComparator : DiffUtil.ItemCallback<MarkerData>() {
    override fun areItemsTheSame(
        oldItem: MarkerData,
        newItem: MarkerData,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MarkerData,
        newItem: MarkerData,
    ): Boolean {
        return oldItem == newItem
    }
}
