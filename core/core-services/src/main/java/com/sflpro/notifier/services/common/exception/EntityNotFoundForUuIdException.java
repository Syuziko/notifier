package com.sflpro.notifier.services.common.exception;

import com.sflpro.notifier.db.entities.AbstractDomainEntityModel;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Ruben Dilanyan
 * Company: SFL LLC
 * Date: 1/27/15
 * Time: 5:34 PM
 */
public class EntityNotFoundForUuIdException extends ServicesRuntimeException {
    private static final long serialVersionUID = -5263374036253353964L;

    /* Properties */
    private final String uuId;

    private final Class<? extends AbstractDomainEntityModel> entityClass;

    public EntityNotFoundForUuIdException(final String uuId, final Class<? extends AbstractDomainEntityModel> entityClass) {
        super("Entity with uuId " + uuId + " of class - " + entityClass.getName() + " is not found");
        this.uuId = uuId;
        this.entityClass = entityClass;
    }

    /* Getters and setters */
    public String getUuId() {
        return uuId;
    }

    public Class<? extends AbstractDomainEntityModel> getEntityClass() {
        return entityClass;
    }

    /* ToString */

    @Override
    public String toString() {
        final ToStringBuilder builder = new ToStringBuilder(this);
        builder.appendSuper(super.toString());
        builder.append("uuId", uuId);
        builder.append("entityClass", entityClass);
        return builder.build();
    }

}
