package com.sematec.basic.entities

data class DrawerItemEntity(
    val title: String,
    val icon: Int,
    val count: Int,
    val type: DrawerItemType
)