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

package grakn.benchmark.common.action.write;

import grakn.benchmark.common.action.Action;
import grakn.benchmark.common.driver.DbOperation;
import grakn.benchmark.common.world.World;
import grakn.common.collection.Pair;

import java.util.ArrayList;

public abstract class InsertTransactionAction<DB_OPERATION extends DbOperation, ACTION_RETURN_TYPE> extends Action<DB_OPERATION, ACTION_RETURN_TYPE> {
    protected final World.Country country;
    protected final Pair<Long, Long> transaction;
    protected final Long sellerCompanyNumber;
    protected final double value;
    protected final int productQuantity;
    protected final boolean isTaxable;

    public InsertTransactionAction(DB_OPERATION dbOperation, World.Country country, Pair<Long, Long> transaction, Long sellerCompanyNumber, double value, int productQuantity, boolean isTaxable) {
        super(dbOperation);
        this.country = country;
        this.transaction = transaction;
        this.sellerCompanyNumber = sellerCompanyNumber;
        this.value = value;
        this.productQuantity = productQuantity;
        this.isTaxable = isTaxable;
    }

    @Override
    protected ArrayList<Object> inputForReport() {
        return argsList(country, transaction, sellerCompanyNumber, value, productQuantity, isTaxable);
    }

    public enum InsertTransactionActionField implements ComparableField {
        SELLER, BUYER, MERCHANDISE, VALUE, PRODUCT_QUANTITY, IS_TAXABLE, COUNTRY
    }
}
