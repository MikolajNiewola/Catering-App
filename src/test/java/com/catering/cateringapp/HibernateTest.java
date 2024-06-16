package com.catering.cateringapp;

import com.catering.cateringapp.model.Danie;
import com.catering.cateringapp.repository.DanieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HibernateTest {
    @Autowired
    private DanieRepository danieRepository;

    @Test
    public void addDania() {
        danieRepository.deleteAll();
        danieRepository.save(new Danie("Lasagne", "Warstwy makaronu, mięsa mielonego i sosu pomidorowego z serem", 32.00));
        danieRepository.save(new Danie("Krewetki w czosnku", "Krewetki smażone w czosnku i masle", 40.00));
        danieRepository.save(new Danie("Ratatouille", "Duszone warzywa: bakłażan, cukinia, papryka, pomidory", 22.00));
        danieRepository.save(new Danie("Filet z łososia", "Filet z łososia pieczony z ziołami i cytryną", 38.00));
        danieRepository.save(new Danie("Tatar wołowy", "Drobno posiekana wołowina z przyprawami i jajkiem", 45.00));
        danieRepository.save(new Danie("Pizza Margherita", "Pizza z serem i sosem pomidorowym", 25.00));
        danieRepository.save(new Danie("Kurczak Curry", "Kawałki kurczaka w sosie curry z warzywami", 30.00));
        danieRepository.save(new Danie("Sałatka Cezar", "Sałatka z sałatą lodową, kurczakiem, parmezanem i sosem Cezar", 20.00));
        danieRepository.save(new Danie("Spaghetti Carbonara", "Makaron spaghetti z sosem śmietanowym, boczkiem i parmezanem", 28.00));
        danieRepository.save(new Danie("Kotlet schabowy z ziemniakami", "Kotlet schabowy panierowany z ziemniakami i surówką", 35.00));
        danieRepository.save(new Danie("Kotlet mielony z ziemniakami", "Kotlet mielony z ziemniakami i sosem grzybowym", 28.00));
        danieRepository.save(new Danie("Kurczak Teriyaki", "Kawałki kurczaka w sosie Teriyaki z ryżem i warzywami", 32.00));
        danieRepository.save(new Danie("Pierogi ruskie", "Pierogi z nadzieniem ziemniaczano-serowym", 25.00));
        danieRepository.save(new Danie("Gulasz wołowy", "Gulasz z kawałkami wołowiny duszony w sosie z warzywami", 35.00));
        danieRepository.save(new Danie("Sałatka grecka", "Sałatka z pomidorów, ogórków, oliwek, sera feta i oliwy z oliwek", 18.00));
        danieRepository.save(new Danie("Ryba po grecku", "Filet rybny zapiekany z warzywami i sosem pomidorowym", 30.00));
        danieRepository.save(new Danie("Kotlet schabowy z kapustą", "Kotlet schabowy z duszoną kapustą i ziemniakami", 33.00));
        danieRepository.save(new Danie("Krewetki curry", "Krewetki w sosie curry z ryżem basmati", 42.00));
        danieRepository.save(new Danie("Zupa pomidorowa", "Klasyczna zupa pomidorowa z makaronem", 15.00));
        danieRepository.save(new Danie("Kaczka pieczona z jabłkami", "Kaczka pieczona z jabłkami i sosem żurawinowym", 40.00));
    }
}
