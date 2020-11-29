package com.lukacs_peter;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonHandling {

    public static void generateJson(String fileName) {
        Random rand = new Random();

        JSONObject obj = new JSONObject(); //root Json object
        JSONArray items = new JSONArray(); //Json array, containing item objects

        for (int i = 0; i < 10; i++) { //Generate 10 items as Json objects
            JSONObject o = new JSONObject();
            o.put("value", rand.nextInt(100) + 1); //Get a random value from [1..100]
            o.put("weight", rand.nextInt(10) + 1); //Get a random weight from [1..10]
            items.add(o);
        }
        obj.put("maxWeight", rand.nextInt(50) + 50); //Get a random maxWeight from [50..100]
        obj.put("items", items);

        try (FileWriter file = new FileWriter(fileName, false)) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(obj);
    }

    public static Knapsack readJson(String fileName) {
        JSONParser jsonParser = new JSONParser();
        Knapsack knapsack = null;

        try (FileReader reader = new FileReader(fileName))
        {
            JSONObject jObj = (JSONObject) jsonParser.parse(reader); //get file contents as Json object
            JSONArray items = (JSONArray) jObj.get("items"); //get items array from the json object
            System.out.println(jObj.get("maxWeight"));
            int maxWeight = ((Long) jObj.get("maxWeight")).intValue();
            int size = items.size();
            int[] wt = new int[size];
            int[] val = new int[size];

            for (int i = 0; i < size; i++) {
                JSONObject o = (JSONObject) items.get(i);
                wt[i] = ((Long) o.get("weight")).intValue();
                val[i] = ((Long) o.get("value")).intValue();
            }

            knapsack = new Knapsack(size,maxWeight,wt,val);
            System.out.println(knapsack.getItemCount() + " " + knapsack.getMaxWeight() + " " + Arrays.toString(knapsack.getValues()) + " " + Arrays.toString(knapsack.getWeights()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return knapsack;
    }


}
