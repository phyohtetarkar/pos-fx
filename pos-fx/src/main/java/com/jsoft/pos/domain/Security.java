package com.jsoft.pos.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jsoft.pos.util.DateTimeDeSerializer;
import com.jsoft.pos.util.DateTimeSerializer;
import com.jsoft.pos.util.Utils;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("serial")
public class Security implements Serializable {

	/*@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	private LocalDateTime creation;
	private String createUser;
	
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	private LocalDateTime modification;
	private String modifiedUser;*/

	private ObjectProperty<LocalDateTime> creation = new SimpleObjectProperty<>();
	private StringProperty createUser = new SimpleStringProperty();
	
	private ObjectProperty<LocalDateTime> modification = new SimpleObjectProperty<>();
	private StringProperty modifiedUser = new SimpleStringProperty();
	

	@JsonIgnore
	public String getCreateDate() {
		return getCreation().format(Utils.dateTimeFormatter);
	}
	
	@JsonIgnore
	public String getUpdateDate() {
		return getModification().format(Utils.dateTimeFormatter);
	}
	
	public ObjectProperty<LocalDateTime> creationProperty() {
		return this.creation;
	}
	
	@JsonSerialize(using = DateTimeSerializer.class)
	public LocalDateTime getCreation() {
		return this.creationProperty().get();
	}
	
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	public void setCreation(final LocalDateTime creation) {
		this.creationProperty().set(creation);
	}
	
	public StringProperty createUserProperty() {
		return this.createUser;
	}
	
	public String getCreateUser() {
		return this.createUserProperty().get();
	}
	
	public void setCreateUser(final String createUser) {
		this.createUserProperty().set(createUser);
	}
	
	public ObjectProperty<LocalDateTime> modificationProperty() {
		return this.modification;
	}
	
	@JsonSerialize(using = DateTimeSerializer.class)
	public LocalDateTime getModification() {
		return this.modificationProperty().get();
	}
	
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	public void setModification(final LocalDateTime modification) {
		this.modificationProperty().set(modification);
	}
	
	public StringProperty modifiedUserProperty() {
		return this.modifiedUser;
	}
	
	public String getModifiedUser() {
		return this.modifiedUserProperty().get();
	}
	
	public void setModifiedUser(final String modifyUser) {
		this.modifiedUserProperty().set(modifyUser);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createUser.get() == null) ? 0 : createUser.get().hashCode());
		result = prime * result + ((creation.get() == null) ? 0 : creation.get().hashCode());
		result = prime * result + ((modification.get() == null) ? 0 : modification.get().hashCode());
		result = prime * result + ((modifiedUser.get() == null) ? 0 : modifiedUser.get().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Security other = (Security) obj;
		if (createUser.get() == null) {
			if (other.createUser.get() != null)
				return false;
		} else if (!createUser.get().equals(other.createUser.get()))
			return false;
		if (creation.get() == null) {
			if (other.creation.get() != null)
				return false;
		} else if (!creation.get().equals(other.creation.get()))
			return false;
		if (modification.get() == null) {
			if (other.modification.get() != null)
				return false;
		} else if (!modification.get().equals(other.modification.get()))
			return false;
		if (modifiedUser.get() == null) {
			if (other.modifiedUser.get() != null)
				return false;
		} else if (!modifiedUser.get().equals(other.modifiedUser.get()))
			return false;
		return true;
	}
}