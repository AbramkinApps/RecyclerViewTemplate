package com.abramkinapps.android.recyclerviewtemplate

// Тестовые данные для заполнения RecyclerView
class TestData {

   companion object {

    fun getThingList():List<Thing> {

     val things = ArrayList<Thing>()

        for (i in 1..20) {
            things.add(Thing(R.mipmap.ic_launcher_round, "Item $i"))
        }

     return things
    }

}
}