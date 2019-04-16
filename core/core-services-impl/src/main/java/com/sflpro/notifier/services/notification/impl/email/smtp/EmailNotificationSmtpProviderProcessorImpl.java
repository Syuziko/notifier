package com.sflpro.notifier.services.notification.impl.email.smtp;

import com.sflpro.notifier.db.entities.notification.NotificationProviderType;
import com.sflpro.notifier.db.entities.notification.email.EmailNotification;
import com.sflpro.notifier.services.notification.dto.email.MailSendConfiguration;
import com.sflpro.notifier.services.notification.email.SmtpTransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Ruben Vardanyan
 * Company: SFL LLC
 * Date: 4/16/19
 * Time: 8:28 PM
 */
@Component
public class EmailNotificationSmtpProviderProcessorImpl implements EmailNotificationSmtpProviderProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotificationSmtpProviderProcessorImpl.class);

    @Autowired
    @Qualifier("smtpTransportService")
    private SmtpTransportService smtpTransportService;

    public EmailNotificationSmtpProviderProcessorImpl() {
        LOGGER.debug("Initializing email notification smtp provider processor impl");
    }

    @Override
    public boolean processEmailNotification(@Nonnull final EmailNotification emailNotification) {
        Assert.notNull(emailNotification, "Email notification not null");
        Assert.isTrue(NotificationProviderType.SMTP_SERVER.equals(emailNotification.getProviderType()), "Email notification provider type should be SMTP_SERVER");
        Assert.notNull(emailNotification.getSenderEmail(), "Email notification sender for SMTP_SERVER provider should not be null");
        final MailSendConfiguration mailSendConfiguration = createMailSendConfiguration(emailNotification);
        smtpTransportService.sendMessageOverSmtp(mailSendConfiguration);
        LOGGER.debug("Successfully sent email message configuration - {}, notification - {}", mailSendConfiguration, emailNotification);
        return true;
    }

    private MailSendConfiguration createMailSendConfiguration(final EmailNotification emailNotification) {
        final MailSendConfiguration mailSendConfiguration = new MailSendConfiguration();
        mailSendConfiguration.setContent(emailNotification.getContent());
        mailSendConfiguration.setTo(emailNotification.getRecipientEmail());
        mailSendConfiguration.setFrom(emailNotification.getSenderEmail());
        mailSendConfiguration.setSubject(emailNotification.getSubject());
        return mailSendConfiguration;
    }
}
