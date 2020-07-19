package com.davevarga.latestnews

class DataSource {

    companion object{

        fun createDataSet(): ArrayList<NewsPost>{
            val list = ArrayList<NewsPost>()
            list.add(
                NewsPost(
                    "Arwa Ibrahim",
                    "Syria votes for new parliament amid war, economic woes - Al Jazeera English",
                    "Experts say vote lacks legitimacy as candidates are either members or allies of Bashar al-Assad's Baath Party.",
                    "https://www.aljazeera.com/news/2020/07/syria-launches-parliamentary-elections-war-economic-woes-200718174903833.html",
                    "https://www.aljazeera.com/mritems/Images/2020/7/18/73e8f0d6c62f47168a4904d63ea67cd5_18.jpg",
                    Source("al-jazeera-english", "Al Jazeera English" ),"2020-07-19",
                    "Syria is holding parliamentary elections across government-controlled areas"



                )
            )
            list.add(
                NewsPost(
                    "Ashley Strickland",
                    "You can see Comet NEOWISE this month",
                    "Comet NEOWISE will be visible above",
                    "https://www.cnn.com/2020/07/19/world/comet-neowise-july-scn-trnd/index.html",
                    "https://cdn.cnn.com/cnnnext/dam/assets/200708095538-02-comet-neowise-2020-super-tease.jpg",
                    Source("cnn", "CNN" ),"2020-07-19",
                    "none"

                )
            )

            list.add(
                NewsPost(
                    "August Alsina drops new song 'Entanglements'",
                    "Roger Stone Uses Racial Slur on Radio Show",
                    "Mr. Stone, while being questioned about the commutation of his sentence by President Trump",
                    "https://www.nytimes.com/2020/07/19/us/politics/roger-stone-mo-kelly-slur.html",
                    "https://static01.nyt.com/images/2020/08/17/us/politics/17xp-stone-radio/merlin_174523263_7eab793e-8087-4ae0-a2c7-cc19582c5424-facebookJumbo.jpg",
                    Source("cnn", "CNN" ),"2020-07-19",
                    "Later, listing television and radio networks"
                )
            )
            list.add(
                NewsPost(
                    "Hollie Silverman",
                    "Portland police says federal officers won't work in its incident command center",
                    "Camouflaged federal officers without identification badges arrested people protesting",
                    "https://www.cnn.com/2020/07/19/us/portland-police-federal-authorities/index.html",
                    "https://cdn.cnn.com/cnnnext/dam/assets/200705134332-01-portland-protests-july-4-super-tease.jpg",
                    Source("none", "Page Six" ),"2020-07-19",
                    "Later, listing television and radio networks"
                )
            )

            list.add(
                NewsPost(
                    "Ashley Strickland",
                    "You can see Comet NEOWISE this month",
                    "Comet NEOWISE will be visible above",
                    "https://www.nytimes.com/2020/07/19/us/politics/roger-stone-mo-kelly-slur.html",
                    "https://static01.nyt.com/images/2020/08/17/us/politics/17xp-stone-radio/merlin_174523263_7eab793e-8087-4ae0-a2c7-cc19582c5424-facebookJumbo.jpg",
                    Source("cnn", "CNN" ),"2020-07-19",
                    "Later, listing television and radio networks"
                )
            )
            list.add(
                NewsPost(
                    "Corgi pups born!",
                    "RT",
                    "2020.07.10.",
                    "https://www.aljazeera.com/news/2020/07/syria-launches-parliamentary-elections-war-economic-woes-200718174903833.html",
                    "https://www.aljazeera.com/mritems/Images/2020/7/18/73e8f0d6c62f47168a4904d63ea67cd5_18.jpg",
                    Source("al-jazeera-english", "Al Jazeera English" ),"2020-07-19",
                    "Syria is holding parliamentary elections across government-controlled areas"

                )
            )
            return list
        }
    }
}
