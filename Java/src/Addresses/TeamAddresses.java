package Addresses;

import Classes.*;

import java.util.HashMap;
import java.util.Hashtable;

public class TeamAddresses {
    public static HashMap<String, String> loadTeamAddresses(){
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("Arda Kardzhali", "../Teams/EAST/Arda Kardzhali");
        hashMap.put("Beroe Stara Zagora", "../Teams/EAST/Beroe Stara Zagora");
        hashMap.put("Botev Plovdiv", "../Teams/EAST/Botev Plovdiv");
        hashMap.put("Cherno More Varna", "../Teams/EAST/Cherno More Varna");
        hashMap.put("Dobrudzha Dobrich", "../Teams/EAST/Dobrudzha Dobrich");
        hashMap.put("Dunav Ruse", "../Teams/EAST/Dunav Ruse");
        hashMap.put("Etar Veliko Tarnovo", "../Teams/EAST/Etar Veliko Tarnovo");
        hashMap.put("Neftohimik Burgas", "../Teams/EAST/Neftohimik Burgas");
        hashMap.put("Ludogorets Razgrad", "../Teams/EAST/Ludogorets Razgrad");
        hashMap.put("Yantra Gabrovo", "../Teams/EAST/Yantra Gabrovo");



        return hashMap;
    }
}
