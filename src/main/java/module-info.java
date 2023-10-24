module waterworld {
    requires transitive hanyaeger;

    exports nl.github.fr3j.tankgimma.scenes;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports nl.github.fr3j.tankgimma.ui.map;
    exports nl.github.fr3j.tankgimma.entities;
    exports nl.github.fr3j.tankgimma.core;
    exports nl.github.fr3j.tankgimma.interfaces;
    exports nl.github.fr3j.tankgimma.handlers;
}
