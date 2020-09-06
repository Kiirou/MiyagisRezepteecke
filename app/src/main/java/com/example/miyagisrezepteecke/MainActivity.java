package com.example.miyagisrezepteecke;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter = null;
    ListView lv = null;
    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;

    List<Recipes> recipes1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipes1 = new ArrayList<>();
        recipes1.add(new Recipes("japanische Nudelsuppe mit Hähnchen", "4 Hähnchenschenkel (entbeint)" +
                "\n200g Ramen-Nudeln" +
                "\n3 Frühlingszwiebeln" +
                "\n6 Zehen Knoblauch" +
                "\n115g Ingwer" +
                "\n1 Lauch" +
                "\n2l Hühnerbrühe" +
                "\n1 Blatt Kombu Algen" +
                "\n125ml helle Sojasauce" +
                "\n50ml Sake" +
                "\n50 ml Mirin" +
                "\n2 Eier" +
                "\n20g Sojasprossen" +
                "\nShichimi Togarashi Gewürzmischung (zum Servieren)", "Zubereitung",
                "Schritt 1: Frühlingszwiebeln in dünne Scheiben schneiden und beiseitestellen. Einen Großteil des Knoblauchs und etwas Ingwer grob hacken. Lauch der Länge nach halbieren und in Scheiben schneiden. Hühnerbrühe, Lauch, gehackten Ingwer, Knoblauch und entbeinte Hähnchenschenkel in einen großen Topf geben und zum Kochen bringen. Für ca. 15 min. kochen, Hühnchen aus dem Topf nehmen, etwas abkühlen lassen und beiseitestellen. Kombu zur Brühe geben und für weitere 15 min. kochen, dann alles durch ein Sieb geben.\n" +
                        "\nSchritt 2: Für die Würzsoße restlichen Knoblauch und Ingwer schälen und klein schneiden. Sojasauce, Sake, Mirin, gehackten Knoblauch und Ingwer in einen kleinen Topf geben. Alles auf mittlerer Stufe für ca. 5 min. erhitzen. Gekochtes Hühnchen in Scheiben schneiden und auf ein Backblech geben. Mit der Hälfte der warmen Würzsoße vermengen und im Ofen bei 200°C für ca. 8 Min. anrösten. Aus dem Ofen nehmen und beiseitestellen.\n" +
                "\nSchritt 3: Eier für ca. 7 Min. kochen, danach schälen und halbieren. Nudeln ca. 6 Min. nach Packungsanleitung kochen. Etwas Würzsoße in eine Servierschüssel geben. Gekochte Nudeln darauf geben, Brühe einfüllen, Hühnchen darauf legen und mit Sojasprossen, einem halben Ei und Frühlingszwiebeln garnieren. Guten Appetit!", R.drawable.ramen));

        recipes1.add(new Recipes("Wiener Schnitzel für 4 Personen", "4 Kalbsschnitzel (à 160g)" +
                "\n150g griffiges Mehl" +
                "\n2 Eier" +
                "\n300g Semmelbrösel" +
                "\n1 Zitrone" +
                "\n1 Prise Salz" +
                "\n2EL Backfett, Öl oder Butterschmalz", "Zubereitung", "\n" +
                "Schritt 1: Schnitzel zwischen Frischhaltefolie behutsam klopfen. Fleisch beidseitig salzen, in Mehl wenden, abklopfen, durch die Eier ziehen und in den Bröseln wenden.\n" +
                "\nSchritt 2: Schnitzel ca. 2 Finger hoch Backfett goldgelb backen. Während des Backens die Pfanne ein wenig rütteln, damit die Schnitzel gleichmäßig goldbraun werden. Schnitzel herausheben, auf Küchenpapier abtropfen lassen.\n" +
                "\nSchritt 3: Zitrone in Spalten schneiden und die fertigen Wiener Schnitzel mit Zitronenspalten garnieren.", R.drawable.schnitzel));

        recipes1.add(new Recipes("Toast Hawaii", "8 Scheiben Toastbrot" +
                "\n4EL Butter" +
                "\n8 Scheiben Ananas" +
                "\n8 Scheiben gekochter Schinken" +
                "\n8 dicke Scheiben Emmentaler" +
                "\n4EL Preiselbeeren nach Belieben", "Zubereitung",
                "Schritt 1: Den Backofen auf 220° (Umluft 200°) vorheizen. Toastscheiben auf beiden Seiten toasten und mit Butter bestreichen. Die Ananas abtropfen lassen.\n" +
                        "\nSchritt 2: Toastscheiben nebeneinander auf ein Backblech legen und mit dem Schinken belegen. Je 1 Ananasscheibe darauf legen, mit Käse bedecken und im heißen Ofen (Mitte) in 10-15 Min. goldbraun überbacken. Zum Servieren nach Belieben je 1/2 EL Preiselbeeren in die Mitte der Ananas setzen."
                        , R.drawable.toast));

        recipes1.add(new Recipes("Fermentierte Limonade (für 5 Gläser)", "1l stilles Wasser" +
                "\n3EL Zucker" +
                "\n30ml Zitronensaft (ca. halbe Zitrone)" +
                "\n1EL Molke" +
                "\n300g Erdbeeren" +
                "\nAußerdem: verschließbares Glasgefäß (ca.1,5l Inhalt)",
                 "Zubereitung",
                "Schritt 1: Wasser, Zucker, Zitronensaft und Molke in ein verschließbares Glasgefäß geben und verrühren, bis sich der Zucker vollständig aufgelöst hat. Erdbeeren waschen, in kleine Stücke schneiden, ins Glas geben und verschließen.\n" +
                "\nSchritt 2: Gefäß für 2 Tage bei Zimmertemperatur stehen lassen und 2-mal am Tag kurz schütteln. Nach der Fermentationszeit das Gefäß öffnen und die Limonade probieren. Falls sich noch nicht genug Kohlensäure gebildet hat, Glas wieder verschließen und 1 weiteren Tag fermentieren lassen. Danach die Erdbeeren abschöpfen, die Limonade kalt stellen und innerhalb weniger Tage verbrauchen. Gläser nach Wunsch mit frischen Erdbeerscheiben garnieren.\n" +
                "\nHinweis: Bei der Fermentation mit Molke können geringe Mengen an Alkohol enstehen (unter 0,5% Vol)", R.drawable.limonade));


        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this, recipes1);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        myrecyclerView.setAdapter(myAdapter);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipe, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_shop: {
                startActivity(new Intent(MainActivity.this, Einkaufsliste.class));

            }

        }
        return super.onOptionsItemSelected(item);
    }

}