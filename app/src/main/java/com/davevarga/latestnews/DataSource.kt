package com.davevarga.latestnews

class DataSource {

    companion object{

        fun createDataSet(): ArrayList<NewsPost>{
            val list = ArrayList<NewsPost>()
            list.add(
                NewsPost(
                    "Hijack!",
                    "BBC",
                    "2020.07.12.",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png"

                )
            )
            list.add(
                NewsPost(
                    "Forest Fire!",
                    "Bloomberg",
                    "2020.07.13.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/time_to_build_a_kotlin_app.png"

                )
            )

            list.add(
                NewsPost(
                    "Oceans dying!",
                    "CNN",
                    "2020.07.14.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/coding_for_entrepreneurs.png"
                )
            )
            list.add(
                NewsPost(
                    "Desertification",
                    "Discovery.com",
                    "2020.07.15.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_vasiliy_zukanov.png"
                )
            )

            list.add(
                NewsPost(
                    "Immigrants rallying!",
                    "Sky",
                    "2020.07.03.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/work_life_balance.png"
                )
            )
            list.add(
                NewsPost(
                    "Corgi pups born!",
                    "RT",
                    "2020.07.10.",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/fullsnack_developer.png"

                )
            )
            return list
        }
    }
}