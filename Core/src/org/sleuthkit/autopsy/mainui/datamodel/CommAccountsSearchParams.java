/*
 * Autopsy Forensic Browser
 *
 * Copyright 2021 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.mainui.datamodel;

import java.util.Objects;
import org.sleuthkit.datamodel.Account;

/**
 * Key for accessing data about communication accounts from the DAO.
 */
public class CommAccountsSearchParams {

    private final Account.Type type;
    private final long account_id; // ELTODO do we need this?
    private final Long dataSourceId;
 
    public CommAccountsSearchParams(long account_id, Account.Type type, Long dataSourceId) {
        this.account_id = account_id;
        this.type = type;
        this.dataSourceId = dataSourceId;
    }

    public long getAccountId() {
        return account_id;
    }

    public Account.Type getType() {
        return type;
    }

    public Long getDataSourceId() {
        return dataSourceId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.account_id);
        hash = 23 * hash + Objects.hashCode(this.type);
        hash = 23 * hash + Objects.hashCode(this.dataSourceId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CommAccountsSearchParams other = (CommAccountsSearchParams) obj;
        if (this.account_id != other.account_id) {
            return false;
        }
        if (!Objects.equals(this.dataSourceId, other.dataSourceId)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

}
