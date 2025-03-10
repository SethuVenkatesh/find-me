/*
 * This file is generated by jOOQ.
 */
package generated.jooq.tables.records;


import generated.jooq.tables.Container;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ContainerRecord extends UpdatableRecordImpl<ContainerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>container.id</code>.
     */
    public ContainerRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>container.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>container.container_name</code>.
     */
    public ContainerRecord setContainerName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>container.container_name</code>.
     */
    public String getContainerName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>container.created_at</code>.
     */
    public ContainerRecord setCreatedAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>container.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>container.updated_at</code>.
     */
    public ContainerRecord setUpdatedAt(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>container.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>container.organisation_id</code>.
     */
    public ContainerRecord setOrganisationId(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>container.organisation_id</code>.
     */
    public String getOrganisationId() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ContainerRecord
     */
    public ContainerRecord() {
        super(Container.CONTAINER);
    }

    /**
     * Create a detached, initialised ContainerRecord
     */
    public ContainerRecord(String id, String containerName, LocalDateTime createdAt, LocalDateTime updatedAt, String organisationId) {
        super(Container.CONTAINER);

        setId(id);
        setContainerName(containerName);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setOrganisationId(organisationId);
        resetTouchedOnNotNull();
    }

    /**
     * Create a detached, initialised ContainerRecord
     */
    public ContainerRecord(generated.jooq.tables.pojos.Container value) {
        super(Container.CONTAINER);

        if (value != null) {
            setId(value.getId());
            setContainerName(value.getContainerName());
            setCreatedAt(value.getCreatedAt());
            setUpdatedAt(value.getUpdatedAt());
            setOrganisationId(value.getOrganisationId());
            resetTouchedOnNotNull();
        }
    }
}
