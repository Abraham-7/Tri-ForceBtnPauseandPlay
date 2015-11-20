package com.mygdx.pauseplay;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * Created by Abraham on 2015-11-19.
 */
public class BtnPause_Play extends Game {
    Stage stage;
    ImageButton Ibtnplay,Ibtnpause;
    ImageButton.ImageButtonStyle IBtnsPlay,IBtnsPause;
    TextureAtlas TaPause,TaPlay;
    Skin sPause,sPlay;
    @Override
    public void create() {
        TaPause = new TextureAtlas("Pause2.pack");
        TaPlay = new TextureAtlas("BtnPlay.pack");
        sPause = new Skin(TaPause);
        sPlay = new Skin(TaPlay);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        IBtnsPlay = new ImageButton.ImageButtonStyle();
        IBtnsPause = new ImageButton.ImageButtonStyle();
        IBtnsPause.up = sPause.getDrawable("Pause2on");
        IBtnsPause.down = sPause.getDrawable("Pause2off");
        IBtnsPlay.up = sPlay.getDrawable("BtnPlayOn");
        IBtnsPlay.down = sPlay.getDrawable("BtnPlayoff");
        Ibtnplay = new ImageButton(IBtnsPlay);
        Ibtnpause = new ImageButton(IBtnsPause);
        Ibtnplay.setSize(100, 100);
        Ibtnplay.setPosition(Gdx.graphics.getWidth() - (Ibtnplay.getWidth() + 30), 15);
        Ibtnpause.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("test");
            }
        });
        Ibtnplay.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("CheckPl");
            }
        });

        stage.addActor(Ibtnpause);

        stage.addActor(Ibtnplay);
    }

    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
