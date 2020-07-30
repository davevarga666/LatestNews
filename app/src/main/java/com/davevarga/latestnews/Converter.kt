package com.davevarga.latestnews

class Converter {
    companion object {
        fun convertTitle(title: String, sourceName: String) : String {
            val editedTitle = title.replace(sourceName, "")
            return editedTitle.substring(0, editedTitle.length - 3)
        }
    }

}