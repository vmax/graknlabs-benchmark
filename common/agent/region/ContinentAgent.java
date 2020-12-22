/*
 * Copyright (C) 2020 Grakn Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package grakn.simulation.common.agent.region;

import grakn.simulation.common.action.ActionFactory;
import grakn.simulation.common.agent.base.Agent;
import grakn.simulation.common.agent.base.SimulationContext;
import grakn.simulation.common.driver.DbDriver;
import grakn.simulation.common.driver.DbOperation;
import grakn.simulation.common.world.World;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public abstract class ContinentAgent<DB_OPERATION extends DbOperation> extends Agent<World.Continent, DB_OPERATION> {

    public ContinentAgent(DbDriver<DB_OPERATION> dbDriver, ActionFactory<DB_OPERATION, ?> actionFactory, SimulationContext simulationContext) {
        super(dbDriver, actionFactory, simulationContext);
    }

    @Override
    protected List<World.Continent> getRegions(World world) {
        return world.getContinents().collect(toList());
    }

    protected abstract class ContinentRegion extends Region {

        public ContinentRegion(int iteration, String tracker, Random random, boolean test) {
            super(iteration, tracker, random, test);
        }
    }
}
