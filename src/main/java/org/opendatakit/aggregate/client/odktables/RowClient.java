/*
 * Copyright (C) 2013 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opendatakit.aggregate.client.odktables;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * This object represents a Row on the client side of the code. It is based
 * almost entirely from a copy/paste of
 * org.opendatakit.aggregate.odktables.entity.Row.java
 * <p>
 * It is the client-side analogue of that Row object.
 *
 * @author sudar.sam@gmail.com
 *
 */
public class RowClient implements Serializable {

  /**
     *
     */
  private static final long serialVersionUID = -339683962551463L;

  private String rowId;

  private String rowETag;

  private boolean deleted;

  private String createUser;

  private String lastUpdateUser;

  private RowFilterScopeClient rowFilterScope;

  private String formId;

  private String locale;

  private String savepointType;

  private String savepointTimestampIso8601Date;

  private String savepointCreator;
  
  private String dataETagAtModification;

  private HashMap<String,String> values;

  /**
   * Construct a row for insertion.
   *
   * @param rowId
   * @param values
   */
  public static RowClient forInsert(String rowId, HashMap<String,String> values) {
    RowClient row = new RowClient();
    row.rowId = rowId;
    row.values = values;
    row.rowFilterScope = RowFilterScopeClient.EMPTY_ROW_FILTER_SCOPE;
    return row;
  }

  /**
   * Construct a row for updating.
   *
   * @param rowId
   * @param rowETag
   * @param values
   */
  public static RowClient forUpdate(String rowId, String rowETag, HashMap<String,String> values) {
    RowClient row = new RowClient();
    row.rowId = rowId;
    row.rowETag = rowETag;
    row.values = values;
    return row;
  }

  public RowClient() {
    this.rowId = null;
    this.rowETag = null;
    this.deleted = false;
    this.createUser = null;
    this.lastUpdateUser = null;
    this.rowFilterScope = null;
    this.savepointType = null;
    this.formId = null;
    this.locale = null;
    this.savepointTimestampIso8601Date = null;
    this.savepointCreator = null;
    this.dataETagAtModification = null;
    this.values = new HashMap<String,String>();
  }

  public RowClient(RowClient r) {
    this.rowId = r.rowId;
    this.rowETag = r.rowETag;
    this.deleted = r.deleted;
    this.createUser = r.createUser;
    this.lastUpdateUser = r.lastUpdateUser;
    this.rowFilterScope = r.rowFilterScope;
    this.savepointType = r.savepointType;
    this.formId = r.formId;
    this.locale = r.locale;
    this.savepointTimestampIso8601Date = r.savepointTimestampIso8601Date;
    this.savepointCreator = r.savepointCreator;
    this.dataETagAtModification = r.dataETagAtModification;
    this.values = r.values;
  }

  public String getRowId() {
    return this.rowId;
  }

  public String getRowETag() {
    return this.rowETag;
  }

  public boolean isDeleted() {
    return this.deleted;
  }

  public String getCreateUser() {
    return createUser;
  }

  public String getLastUpdateUser() {
    return lastUpdateUser;
  }

  public RowFilterScopeClient getRowFilterScope() {
    return rowFilterScope;
  }

  public HashMap<String,String> getValues() {
    return this.values;
  }

  public String getSavepointType() {
    return this.savepointType;
  }

  public String getSavepointCreator() {
    return this.savepointCreator;
  }

  public String getFormId() {
    return this.formId;
  }

  public String getLocale() {
    return this.locale;
  }

  public String getSavepointTimestampIso8601Date() {
    return this.savepointTimestampIso8601Date;
  }
  
  public String getDataETagAtModification() {
    return this.dataETagAtModification;
  }

  public void setRowId(final String rowId) {
    this.rowId = rowId;
  }

  public void setRowETag(final String rowETag) {
    this.rowETag = rowETag;
  }

  public void setDeleted(final boolean deleted) {
    this.deleted = deleted;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public void setLastUpdateUser(String lastUpdateUser) {
    this.lastUpdateUser = lastUpdateUser;
  }

  public void setRowFilterScope(RowFilterScopeClient rowFilterScope) {
    this.rowFilterScope = rowFilterScope;
  }

  public void setValues(final HashMap<String,String> values) {
    this.values = values;
  }

  public void setSavepointType(String savepointType) {
    this.savepointType = savepointType;
  }

  public void setSavepointCreator(String savepointCreator) {
    this.savepointCreator = savepointCreator;
  }

  public void setFormId(String formId) {
    this.formId = formId;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  /**
   * Expects a string as generated by {@link WebUtils#iso8601Date(Date)}.
   *
   * @param timestamp
   */
  public void setSavepointTimestampIso8601Date(String savepointTimestampIso8601Date) {
    this.savepointTimestampIso8601Date = savepointTimestampIso8601Date;
  }

  public void setDataETagAtModification(String dataETagAtModification) {
    this.dataETagAtModification = dataETagAtModification;
  }
  
  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((rowId == null) ? 0 : rowId.hashCode());
    result = prime * result + ((rowETag == null) ? 0 : rowETag.hashCode());
    result = prime * result + (deleted ? 1231 : 1237);
    result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
    result = prime * result + ((lastUpdateUser == null) ? 0 : lastUpdateUser.hashCode());
    result = prime * result + ((rowFilterScope == null) ? 0 : rowFilterScope.hashCode());
    result = prime * result + ((formId == null) ? 0 : formId.hashCode());
    result = prime * result + ((locale == null) ? 0 : locale.hashCode());
    result = prime * result + ((savepointType == null) ? 0 : savepointType.hashCode());
    result = prime * result + ((savepointTimestampIso8601Date == null) ? 0 : savepointTimestampIso8601Date.hashCode());
    result = prime * result + ((savepointCreator == null) ? 0 : savepointCreator.hashCode());
    result = prime * result + ((dataETagAtModification == null) ? 0 : dataETagAtModification.hashCode());
    result = prime * result + ((values == null) ? 0 : values.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof RowClient))
      return false;
    RowClient other = (RowClient) obj;

    if (rowETag == null) {
      if (other.rowETag != null)
        return false;
    } else if (!rowETag.equals(other.rowETag))
      return false;

    if (savepointTimestampIso8601Date == null) {
      if (other.savepointTimestampIso8601Date != null)
        return false;
    } else if (!savepointTimestampIso8601Date.equals(other.savepointTimestampIso8601Date))
      return false;

    if (rowId == null) {
      if (other.rowId != null)
        return false;
    } else if (!rowId.equals(other.rowId))
      return false;

    if (deleted != other.deleted)
      return false;

    if (createUser == null) {
      if (other.createUser != null)
        return false;
    } else if (!createUser.equals(other.createUser))
      return false;

    if (lastUpdateUser == null) {
      if (other.lastUpdateUser != null)
        return false;
    } else if (!lastUpdateUser.equals(other.lastUpdateUser))
      return false;

    if (rowFilterScope == null) {
      if (other.rowFilterScope != null)
        return false;
    } else if (!rowFilterScope.equals(other.rowFilterScope))
      return false;

    if (formId == null) {
      if (other.formId != null)
        return false;
    } else if (!formId.equals(other.formId))
      return false;

    if (locale == null) {
      if (other.locale != null)
        return false;
    } else if (!locale.equals(other.locale))
      return false;

    if (savepointType == null) {
      if (other.savepointType != null)
        return false;
    } else if (!savepointType.equals(other.savepointType))
      return false;
    
    if (savepointTimestampIso8601Date == null) {
      if (other.savepointTimestampIso8601Date != null)
        return false;
    } else if (!savepointTimestampIso8601Date.equals(other.savepointTimestampIso8601Date))
      return false;

    if (dataETagAtModification == null) {
      if (other.dataETagAtModification != null)
        return false;
    } else if (!dataETagAtModification.equals(other.dataETagAtModification))
      return false;

    if (savepointCreator == null) {
      if (other.savepointCreator != null)
        return false;
    } else if (!savepointCreator.equals(other.savepointCreator))
      return false;

    if (values == null) {
      if (other.values != null)
        return false;
    } else if (!values.equals(other.values))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Row [rowId=");
    builder.append(rowId);
    builder.append(", rowETag=");
    builder.append(rowETag);
    builder.append(", deleted=");
    builder.append(deleted);
    builder.append(", createUser=");
    builder.append(createUser);
    builder.append(", lastUpdateUser=");
    builder.append(lastUpdateUser);
    builder.append(", rowFilterScope=");
    builder.append(rowFilterScope.toString());
    builder.append(", formId=");
    builder.append(formId);
    builder.append(", locale=");
    builder.append(locale);
    builder.append(", savepointType=");
    builder.append(savepointType);
    builder.append(", savepointTimestampIso8601Date=");
    builder.append(savepointTimestampIso8601Date);
    builder.append(", savepointCreator=");
    builder.append(savepointCreator);
    builder.append(", dataETagAtModification=");
    builder.append(dataETagAtModification);
    builder.append(", values=");
    builder.append(values);
    builder.append("]");
    return builder.toString();
  }
}