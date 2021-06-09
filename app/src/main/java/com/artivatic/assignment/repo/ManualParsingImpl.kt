package com.artivatic.assignment.repo

import com.artivatic.assignment.api.DataApi
import com.artivatic.assignment.model.Data
import com.artivatic.assignment.model.RowsItem
import com.google.gson.Gson
import org.json.JSONObject
import java.io.BufferedInputStream
import java.net.URL

class ManualParsingImpl : DataApi {
    override suspend fun getData(): Data {

        val url = URL("https://run.mocky.io/v3/c4ab4c1c-9a55-4174-9ed2-cbbe0738eedf")
        val connection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line in bufferedReader.readLines()) {
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val responseJson = stringBuffer.toString()

        return Gson().fromJson(responseJson, Data::class.java)
    }
}