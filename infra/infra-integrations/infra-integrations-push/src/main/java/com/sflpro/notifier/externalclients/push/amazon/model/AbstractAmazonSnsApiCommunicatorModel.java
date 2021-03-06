package com.sflpro.notifier.externalclients.push.amazon.model;

import com.sflpro.notifier.externalclients.push.common.model.AbstractPushNotificationApiCommunicatorModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Ruben Dilanyan
 * Company: SFL LLC
 * Date: 4/9/15
 * Time: 3:32 PM
 */
public abstract class AbstractAmazonSnsApiCommunicatorModel extends AbstractPushNotificationApiCommunicatorModel {

    private static final long serialVersionUID = 1713115763225923897L;

    /* Constructors */
    public AbstractAmazonSnsApiCommunicatorModel() {
    }


    /* Equals, HashCode and ToString */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractAmazonSnsApiCommunicatorModel)) {
            return false;
        }
        final EqualsBuilder builder = new EqualsBuilder();
        return builder.build();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        return builder.build();
    }

    @Override
    public String toString() {
        final ToStringBuilder builder = new ToStringBuilder(this);
        return builder.build();
    }
}
