package Pokedex.Controller;

import Pokedex.Pokedex;

import java.io.IOException;

public class PokedexController {
    public void onButtonSearchClick() {
        // under construction
    }

    public void onButtonShowAllClick() throws IOException {
        Pokedex.instance.loadView("ShowAllView");
    }
}
