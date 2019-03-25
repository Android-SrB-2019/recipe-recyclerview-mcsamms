package work.nbcc.mattsamms.reciperecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import work.nbcc.mattsamms.model.Recipe;

public class RecipeView extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);
        Intent intent = getIntent();
        Recipe recipe = (Recipe)intent.getSerializableExtra("Recipe");

        TextView heading = findViewById(R.id.recipe_name);
        ImageView imageView = findViewById(R.id.recipe_image);
        heading.setText(recipe.name);
        Picasso.get().load(recipe.image).fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        TextView description = findViewById(R.id.recipe_ingredients);
        TextView directions = findViewById(R.id.recipe_directions);
        description.setText(recipe.ingredients);
        directions.setText(recipe.directions);
    }
}
