package com.example.geomob.DataClasses

import android.content.Context
import com.example.geomob.Database.PaysDatabase
import com.example.geomob.R
import com.example.geomob.Threads.AppExecutors

class Initializer{
    companion object{
        private lateinit var paysDatabase : PaysDatabase

        fun initializeDatabase(context : Context){
            paysDatabase = PaysDatabase.getDatabase(context)

            val dz = Pays("DZ","Algeria", "Algiers", "", 2381741, 42972878, R.raw.dz, false)
            val eg = Pays("EG","Egypt", "Cairo", "", 1010408, 100075480, R.raw.eg, false)
            val sa = Pays("SA", "Saudi Arabia", "Riyadh", "", 2149690, 34218169, R.raw.sa, false)
            val jp = Pays("JP", "Japan", "Tokyo", "", 377975, 126150000, R.raw.jp, false)
            val my = Pays("MY", "Malaysia", "Kuala Lumpur", "", 330803, 32730000, R.raw.my, false)

            val res1 = Ressource(null, "Oil", "Algeria is one of the biggest oil producers in the world.", "DZ")
            val res2 = Ressource(null, "Natural gas", "Algeria has abundant natural gas reserves.", "DZ")
            val res3 = Ressource(null, "Helium", "Algeria has approximately 21% of the world’s helium deposits, and is the second largest producer of helium, after the United States.", "DZ")
            val res4 = Ressource(null, "Gold", "Algeria has many gold deposits within its borders.", "DZ")

            val res5 = Ressource(null, "Petroleum", " The search for petroleum began earlier in Egypt than elsewhere in the Middle East", "EG")
            val res6 = Ressource(null, "Natural gas", "A joint Egyptian-Italian gas discovery was made in the north delta near Abū Māḍī in 1970", "EG")
            val res7 = Ressource(null, "Iron ore", "ron ore is extracted from deposits at Aswān, and development work has continued at Al-Baḥriyyah Oasis. ", "EG")
            val res8 = Ressource(null, "Phosphates", "Several of Egypt’s major known phosphate deposits are mined at Isnā, Ḥamrāwayn, and Safājah.", "EG")

            val res9 = Ressource(null, "Metals", "MGBM currently operates five gold mines in Saudi Arabia and since 1988 has produced more than 4 million ounces of gold.", "SA")
            val res10 = Ressource(null, "Fossil Fuels", "The country is a leading producer of oil and natural gas, and is ranked eighth in terms of petroleum refining capacity in the world.", "SA")
            val res11 = Ressource(null, "Investment", "According to experts, Saudi Arabia will continue to be the most significant supplier of petroleum to meet the ever-increasing global demand. ", "SA")

            val res12 = Ressource(null, "Minerals", "With few exceptions, Japan’s mineral reserves are small, and the quality of those mined is often poor.", "JP")
            val res13 = Ressource(null, "Mining and quarrying", "Mining for iron and copper essentially ceased after 2000, and Japan now imports virtually all its needs for those two ores.", "JP")
            val res14 = Ressource(null, "Power", "The largest single source of energy is oil;", "JP")
            val res15 = Ressource(null, "The most notable feature of Japan’s economic growth since World War II is the rapid development of manufacturing", "", "JP")

            val res16 = Ressource(null, "Petroleum", "Petroleum products such as crude oil are the most valuable natural resources of the country. ", "MY")
            val res17 = Ressource(null, "Precious Minerals", "Malaysia also has a number of mining sites that mine minerals like gold, copper, tin, silica sand, bauxite, and limestone.", "MY")
            val res18 = Ressource(null, "Agriculture and Forestry", "Agriculture is a major sector in Malaysia since it accounts for around 12% of the national GDP. ", "MY")

            val pers1 = Personalite(null, "Abdelkader ibn Muhieddine", R.drawable.dz_aek, "DZ")
            val pers2 = Personalite(null, "Houari Boumédiène", R.drawable.dz_bmd, "DZ")
            val pers3 = Personalite(null, "Abdelhamid Ben Badis", R.drawable.dz_badis, "DZ")
            val pers4 = Personalite(null, "Larbi Ben M'hidi", R.drawable.dz_arbi, "DZ")

            val pers5 = Personalite(null, "Mohamed Salah", R.drawable.eg_salah, "EG")
            val pers6 = Personalite(null, "Anwar Sadat", R.drawable.eg_sadat, "EG")
            val pers7 = Personalite(null, "Taha Hussein", R.drawable.eg_taha, "EG")

            val pers8 = Personalite(null, "Abdullah of Saudi Arabia", R.drawable.sa_abdullah, "SA")
            val pers9 = Personalite(null, "Mohammed bin Salman", R.drawable.sa_bin_salman, "SA")
            val pers10 = Personalite(null, "Majed Abdullah", R.drawable.sa_majed, "SA")

            val pers11 = Personalite(null, "Hayao Miyazaki", R.drawable.jp_miyazaki, "JP")
            val pers12 = Personalite(null, "Ken Watanabe", R.drawable.jp_ken, "JP")
            val pers13 = Personalite(null, "Satoshi Kon", R.drawable.jp_satoshi, "JP")

            val pers14 = Personalite(null, "Mahathir Mohamad", R.drawable.ml_mahatir, "MY")
            val pers15 = Personalite(null, "Lee Chong Wei", R.drawable.ml_lee, "MY")
            val pers16 = Personalite(null, "Hussein Onn", R.drawable.ml_onn, "MY")

            val event1 = Evenement(null, "19th century colonialism", "North African boundaries have shifted during various stages of the conquests. The borders of modern Algeria were created by the French, whose colonization began in 1830 (French invasion began on July 5). To benefit French colonists (many of whom were not in fact of French origin but Italian, Maltese, and Spanish) and nearly the entirety of whom lived in urban areas, northern Algeria was eventually organized into overseas departments of France, with representatives in the French National Assembly. France controlled the entire country, but the traditional Muslim population in the rural areas remained separated from the modern economic infrastructure of the European community.", "DZ")
            val event2 = Evenement(null, "Rise of Algerian nationalism and French resistance", "A new generation of Islamic leadership emerged in Algeria at the time of World War I and grew to maturity during the 1920s and 1930s. Various groups were formed in opposition to French rule, most notable the National Liberation Front (FLN) and the National Algerian Movement.", "DZ")
            val event3 = Evenement(null, "Ben Bella presidency (1962–65)", "The referendum was held in Algeria on 1 July 1962, and France declared Algeria independent on 3 July. On 8 September 1963, a constitution was adopted by referendum, and later that month, Ahmed Ben Bella was formally elected the first president, after receiving support from the military, led by Houari Boumediène. The war for independence and its aftermath had severely disrupted Algeria's society and economy. In addition to the physical destruction, the exodus of the colons deprived the country of most of its managers, civil servants, engineers, teachers, physicians, and skilled workers. The homeless and displaced numbered in the hundreds of thousands, many suffering from illness, and some 70 percent of the workforce was unemployed.", "DZ")

            val event4 = Evenement(null, "Reign of Nasser", "Nasser assumed power as President in June 1956. British forces completed their withdrawal from the occupied Suez Canal Zone on 13 June 1956. He nationalized the Suez Canal on 26 July 1956, prompting the 1956 Suez Crisis.", "EG")
            val event5 = Evenement(null, "Reign of Sadat", "Sadat switched Egypt's Cold War allegiance from the Soviet Union to the United States, expelling Soviet advisors in 1972. He launched the Infitah economic reform policy, while clamping down on religious and secular opposition.", "EG")
            val event6 = Evenement(null, "Terrorist insurgency", "In 1980s, 1990s, and 2000s, terrorist attacks in Egypt became numerous and severe, and began to target Copts and foreign tourists as well as government officials. Some scholars and authors have credited Islamist writer Sayyid Qutb, who was executed in 1967, as the inspiration for the new wave of attacks.", "EG")

            val event7 = Evenement(null, "Ottoman Hejaz", "In the 16th century, the Ottomans added the Red Sea and Persian Gulf coast (the Hejaz, Asir and Al-Ahsa) to the Empire and claimed suzerainty over the interior. One reason was to thwart Portuguese attempts to attack the Red Sea (hence the Hejaz) and the Indian Ocean.[86] Ottoman degree of control over these lands varied over the next four centuries with the fluctuating strength or weakness of the Empire's central authority.[87][88] These changes contributed to later uncertainties, such as the dispute with Transjordan over the inclusion of the sanjak of Ma'an, including the cities of Ma'an and Aqaba.", "SA")
            val event8 = Evenement(null, "Foundation of the Saud dynasty", "The emergence of what was to become the Saudi royal family, known as the Al Saud, began in Nejd in central Arabia in 1744, when Muhammad bin Saud, founder of the dynasty, joined forces with the religious leader Muhammad ibn Abd al-Wahhab,[89] founder of the Wahhabi movement, a strict puritanical form of Sunni Islam.[90] This alliance formed in the 18th century provided the ideological impetus to Saudi expansion and remains the basis of Saudi Arabian dynastic rule today", "SA")
            val event9 = Evenement(null, "Post-unification", "The new kingdom was reliant on limited agriculture and pilgrimage revenues.[103] In 1938, vast reserves of oil were discovered in the Al-Ahsa region along the coast of the Persian Gulf, and full-scale development of the oil fields began in 1941 under the US-controlled Aramco (Arabian American Oil Company). Oil provided Saudi Arabia with economic prosperity and substantial political leverage internationally", "SA")

            val event10 = Evenement(null, "Postwar growth and prosperity", "Shigeru Yoshida served as prime minister in 1946–1947 and 1948–1954, and played a key role in guiding Japan through the occupation.[292] His policies, known as the Yoshida Doctrine, proposed that Japan should forge a tight relationship with the United States and focus on developing the economy rather than pursuing a proactive foreign policy.[293] Yoshida was one of the longest serving prime ministers in Japanese history and the third-longest serving Prime Minister in Post-occupation Japan.[294] Yoshida's Liberal Party merged in 1955 into the new Liberal Democratic Party (LDP),[295] which went on to dominate Japanese politics for the remainder of the Shōwa period", "JP")
            val event11 = Evenement(null, "Heisei period (1989–2019)", "Emperor Akihito's reign began upon the death of his father, Emperor Hirohito. The economic bubble popped in 1989, and stock and land prices plunged as Japan entered a deflationary spiral. Banks found themselves saddled with insurmountable debts that hindered economic recovery.[317] Stagnation worsened as the birthrate declined far below replacement level", "JP")
            val event12 = Evenement(null, "Reiwa period (2019–present)", "Emperor Naruhito's reign began upon the abdication of his father, Emperor Akihito, on May 1, 2019.", "JP")

            val event13 = Evenement(null, "Mahathir administration", "The restoration of democracy after the 1969 crisis caused disputes in the UMNO, a struggle of power which increased after the death of Tun Abdul Razak. The ailing Datuk Hussein Bin Onn replaced him, but the fight for control shifted to appointing the deputy prime minister. Mahathir Mohamad was chosen, an advocate of Bumiputra who also tried to benefit the other ethnic communities.", "MY")
            val event14 = Evenement(null, "Najib administration", "Najib Razak entered office as Prime Minister with a sharp focus on domestic economic issues and political reform. On his first day as Prime Minister, Najib announced as his first actions the removal of bans on two opposition newspapers, Suara Keadilan and Harakahdaily, run by the opposition leader Datuk Seri Anwar Ibrahim-led People's Justice Party and the Pan Islamic Party, respectively, and the release of 13 people held under the Internal Security Act.", "MY")
            val event15 = Evenement(null, "Second Mahathir administration", "Tun Dr Mahathir Mohamad, who left UMNO in 2016 and formed his own political party, the Malaysian United Indigenous Party which teamed up with three other political parties to form Pakatan Harapan, was sworn in as the Prime Minister of Malaysia after winning the election on 10 May 2018. He defeated Najib Razak who led Barisan Nasional political party that had previously ruled Malaysia for 61 years since 1957. Najib Razak was defeated by Tun Dr Mahathir Mohamad due to the factors such as the ongoing political scandal which is 1Malaysia Development Berhad scandal that has arisen since 2015, the introduction of Goods and Services Tax (Malaysia) of 6% since 1 April 2015, high cost of living and openly extreme criticism against Tun Dr. Mahathir Mohamad.", "MY")


            val paysList = arrayListOf(dz, eg, sa, jp, my)

            val resourcesList = arrayListOf(res1, res2, res3, res4, res5, res6, res7, res7, res8, res9, res10,
                                            res11, res12, res13, res14, res15, res16, res17, res18, res18)

            val personsList = arrayListOf(pers1, pers2, pers3, pers4, pers5, pers6, pers7, pers8, pers9,
                                        pers10, pers11, pers12, pers13, pers14, pers15, pers16)

            val eventList = arrayListOf(event1, event2, event3, event4, event5, event6, event7, event8, event9,
                                        event10, event11, event12, event13, event14, event15)

            for (pays in paysList){
                addPays(pays)
            }

            for (resource in resourcesList){
                addRessource(resource)
            }

            for (person in personsList){
                addPersonalite(person)
            }

            for (event in eventList){
                addEvent(event)
            }
        }

        private fun addPays(pays: Pays){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addPays(pays)
            }
        }

        private fun addRessource(ress : Ressource){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addRessource(ress)
            }
        }

        private fun addPersonalite(pers : Personalite){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addPersonalite(pers)
            }
        }

        private fun addPaysPhoto(paysPhoto : PaysPhoto){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addPaysPhoto(paysPhoto)
            }
        }

        private fun addPaysVideo(paysVideo : PaysVideo){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addPaysVideo(paysVideo)
            }
        }

        private fun addPersonalitePhoto(personalitePhoto : PersonalitePhoto){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addPersonalitePhoto(personalitePhoto)
            }
        }

        private fun addTweet(tweet : Tweet){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addTweet(tweet)
            }
        }

        private fun addEvent(event: Evenement){
            AppExecutors.instance!!.diskIO().execute {
                paysDatabase.paysDao().addEvenement(event)
            }
        }
    }
}