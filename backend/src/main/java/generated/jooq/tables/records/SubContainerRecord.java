/*
 * This file is generated by jOOQ.
 */
package generated.jooq.tables.records;


import generated.jooq.tables.SubContainer;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class SubContainerRecord extends UpdatableRecordImpl<SubContainerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sub_container.id</code>.
     */
    public SubContainerRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>sub_container.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sub_container.created_at</code>.
     */
    public SubContainerRecord setCreatedAt(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>sub_container.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>sub_container.sub_container_name</code>.
     */
    public SubContainerRecord setSubContainerName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>sub_container.sub_container_name</code>.
     */
    public String getSubContainerName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sub_container.updated_at</code>.
     */
    public SubContainerRecord setUpdatedAt(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>sub_container.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>sub_container.container_id</code>.
     */
    public SubContainerRecord setContainerId(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>sub_container.container_id</code>.
     */
    public String getContainerId() {
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
     * Create a detached SubContainerRecord
     */
    public SubContainerRecord() {
        super(SubContainer.SUB_CONTAINER);
    }

    /**
     * Create a detached, initialised SubContainerRecord
     */
    public SubContainerRecord(String id, LocalDateTime createdAt, String subContainerName, LocalDateTime updatedAt, String containerId) {
        super(SubContainer.SUB_CONTAINER);

        setId(id);
        setCreatedAt(createdAt);
        setSubContainerName(subContainerName);
        setUpdatedAt(updatedAt);
        setContainerId(containerId);
        resetTouchedOnNotNull();
    }

    /**
     * Create a detached, initialised SubContainerRecord
     */
    public SubContainerRecord(generated.jooq.tables.pojos.SubContainer value) {
        super(SubContainer.SUB_CONTAINER);

        if (value != null) {
            setId(value.getId());
            setCreatedAt(value.getCreatedAt());
            setSubContainerName(value.getSubContainerName());
            setUpdatedAt(value.getUpdatedAt());
            setContainerId(value.getContainerId());
            resetTouchedOnNotNull();
        }
    }
}
