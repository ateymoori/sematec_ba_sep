package com.sematec.basic.utils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.Reader

object GsonUtils {

    val gson: Gson = GsonBuilder()
        .serializeNulls()
        .create()

    fun Any.toStringByGson(): String = gson.toJson(this)

    inline fun <reified K, reified V> String.toMapByGson(): Map<K, V> = if (isNotEmpty()) {
        Gson().fromJson<HashMap<K, V>>(
            this,
            TypeToken.getParameterized(HashMap::class.java, K::class.java, V::class.java).type
        )
    } else {
        mapOf<K, V>()
    }

    inline fun <reified T> String.toObjectByGson(): T = Gson().fromJson<T>(this, T::class.java)

    inline fun <reified T> Reader.toObjectByGson(): T = Gson().fromJson<T>(this, T::class.java)

    fun <T> String.toObjectByGson(cls: Class<T>): T = gson.fromJson<T>(this, cls)

    fun <T> Reader.toObjectByGson(cls: Class<T>): T = gson.fromJson<T>(this, cls)

    inline fun <reified T> String.toListByGson(): List<T> = if (isNotEmpty()) {
        Gson().fromJson<List<T>>(
            this,
            TypeToken.getParameterized(ArrayList::class.java, T::class.java).type
        )
    } else {
        listOf<T>()
    }

    inline fun <reified T> String.toMutableListByGson(): MutableList<T> = if (isNotEmpty()) {
        Gson().fromJson<MutableList<T>>(
            this,
            TypeToken.getParameterized(ArrayList::class.java, T::class.java).type
        )
    } else {
        mutableListOf<T>()
    }

}