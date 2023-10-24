module waterworld {
    requires transitive hanyaeger;

    exports nl.github.fr3j.tankgimma.scenes;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports nl.github.fr3j.tankgimma.entities.map;
    exports nl.github.fr3j.tankgimma.entities;
    exports nl.github.fr3j.tankgimma.core;
}
