package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BasicShield extends DynamicSpriteEntity implements Shield {
    private boolean active = false;

    public BasicShield(Coordinate2D location) {
        super("sprites/shield.png", location, new Size(50, 50)); // Adjust the size to enclose the tank
        setVisible(false);
    }


    @Override
    public void activate() {
        active = true;
        setVisible(true);
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void deactivate() {
        active = false;
        setVisible(false);
    }
}
