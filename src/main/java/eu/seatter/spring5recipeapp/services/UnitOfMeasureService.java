package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 27/11/2018
 * Time: 15:02
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
