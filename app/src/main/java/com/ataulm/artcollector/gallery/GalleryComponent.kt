package com.ataulm.artcollector.gallery

import com.ataulm.artcollector.ApplicationComponent
import com.ataulm.artcollector.ArtCollectorApplication
import com.ataulm.artcollector.gallery.ui.GalleryActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [GalleryModule::class], dependencies = [ApplicationComponent::class])
internal interface PaintingsComponent {

    fun inject(activity: GalleryActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: GalleryActivity): Builder

        fun withParent(component: ApplicationComponent): Builder

        fun build(): PaintingsComponent
    }
}

internal fun GalleryActivity.injectDependencies() {
    DaggerPaintingsComponent.builder()
            .withParent(ArtCollectorApplication.component(this))
            .activity(this)
            .build()
            .inject(this)
}
