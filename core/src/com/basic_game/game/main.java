package com.basic_game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class main extends ApplicationAdapter {


	ShapeRenderer shapeRenderer;


	Stage stage;
	TextButton button;

	//variables for square
	float squareX = 10;
	float squareY = 10;
	float squareW = 50;
	float squareH = 50;

	float xSpeed = 0;
	float ySpeed = 0;
	float speed = 120;


	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();




		//setup input
		Gdx.input.setInputProcessor(new InputAdapter(){
			//define the inputs here
			public boolean keyDown(int key){

				if(key == Input.Keys.UP) {
					//move up
					ySpeed = speed;
				}
				if(key == Input.Keys.LEFT){
					//move left
					xSpeed = -speed;
				}
				if(key == Input.Keys.RIGHT){
					//move right
					xSpeed = speed;

				}
				if(key == Input.Keys.DOWN){
					//move down
					ySpeed = -speed;
				}
				return true;
			}

			@Override
			public boolean keyUp(int key) {
				if(key == Input.Keys.UP) {
					//move up
					ySpeed =0;
				}
				if(key == Input.Keys.LEFT){
					//move left
					xSpeed = 0;
				}
				if(key == Input.Keys.RIGHT){
					//move right
					xSpeed = 0;

				}
				if(key == Input.Keys.DOWN){
					//move down
					ySpeed = 0;
				}
				return true;
			}

			@Override
			public boolean keyTyped(char key) {
				if(key == 'w'){
					speed +=100;
				}
				else if (key == 's'){
					speed -=100;
				}
				return true;

			}
		});

		}



	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		//circleX += xSpeed *  Gdx.graphics.getDeltaTime();
		//circleY += ySpeed *  Gdx.graphics.getDeltaTime();


		//check if window has been resized
		float newSize = Math.min(Gdx.graphics.getHeight()/12,Gdx.graphics.getWidth()/12);
		squareW = newSize;
		squareH = newSize;


		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		squareX +=(xSpeed * Gdx.graphics.getDeltaTime());
		squareY +=(ySpeed * Gdx.graphics.getDeltaTime());


		//do the main drawing
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.rect( squareX, squareY, squareW,squareH);
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();

	}
}
