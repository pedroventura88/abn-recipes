package abn.com.receipes.core.receipe;

import com.abn.receipe.models.Receipe;
import com.abn.receipe.models.Receipes;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReceipeMapper extends PageMapper {
    public Receipe toApi(ReceipeEntity entity) {
        return new Receipe()
                .id(entity.getId())
                .name(entity.getName())
                .servings(entity.getServings())
                .isVegetarian(entity.getIsVegetarian())
                .ingredients(new ArrayList<>(entity.getIngredients()));
    }

    public Receipes toReceipes(Page<ReceipeEntity> inputPage){
        return new Receipes()
                .page(toApiPage(inputPage))
                .items(inputPage.getContent().stream().map(receipe -> toApi(receipe)).collect(Collectors.toList()));
    }
}
