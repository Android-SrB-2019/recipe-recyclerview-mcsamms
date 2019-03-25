package work.nbcc.mattsamms.reciperecycler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import work.nbcc.mattsamms.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private LayoutInflater mInflater;
    private LinkedList<Recipe> mRecipes;

    RecipeAdapter(Context context, LinkedList<Recipe> recipes){
        mInflater = LayoutInflater.from(context);
//        this.mRecipeName = recipeName;
//        this.mRecipeDesc = recipeDesc;
        this.mRecipes = recipes;
    }
    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.recipe_list_textviews, viewGroup, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder recipeViewHolder, int i) {
        Recipe r = mRecipes.get(i);
        recipeViewHolder.recipeNameTextView.setText(r.name);
        recipeViewHolder.recipeDescTextView.setText(r.description);
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView recipeNameTextView;
        final TextView recipeDescTextView;
        final RecipeAdapter mAdapter;

        RecipeViewHolder(View itemView, RecipeAdapter adapter){
            super(itemView);
            recipeNameTextView = itemView.findViewById(R.id.item_title);
            recipeDescTextView = itemView.findViewById(R.id.item_desc);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            Recipe element = mRecipes.get(mPosition);
            Intent intent = new Intent(v.getContext(), RecipeView.class);
            //Bundle bundle = new Bundle();
            //bundputle.
            intent.putExtra("Recipe", element);
            v.getContext().startActivity(intent);
        }
    }
}
