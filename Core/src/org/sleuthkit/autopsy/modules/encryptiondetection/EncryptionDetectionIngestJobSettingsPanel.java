/*
 * Autopsy Forensic Browser
 *
 * Copyright 2017-2018 Basis Technology Corp.
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
package org.sleuthkit.autopsy.modules.encryptiondetection;

import java.text.ParseException;
import java.util.logging.Level;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettings;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettingsPanel;

/**
 * Ingest job settings panel for the Encryption Detection module.
 */
final class EncryptionDetectionIngestJobSettingsPanel extends IngestModuleIngestJobSettingsPanel {

    private static final int MEGABYTE_SIZE = 1048576;
    private static final int INVALID_TEXT_FIELD_INPUT_RETURN = -1;
    
    private final Logger logger = Logger.getLogger(EncryptionDetectionIngestJobSettingsPanel.class.getName());
    
    private final DefaultFormatterFactory minimumFileSizeTextFormatterFactory = new DefaultFormatterFactory(new MinimumFileSizeTextFormatter());;
    private final DefaultFormatterFactory minimumEntropyTextFormatterFactory = new DefaultFormatterFactory(new MinimumEntropyTextFormatter());;

    /**
     * Instantiate the ingest job settings panel.
     *
     * @param settings The ingest job settings.
     */
    public EncryptionDetectionIngestJobSettingsPanel(EncryptionDetectionIngestJobSettings settings) {
        initComponents();
        customizeComponents(settings);
    }

    /**
     * Update components with values from the ingest job settings.
     *
     * @param settings The ingest job settings.
     */
    private void customizeComponents(EncryptionDetectionIngestJobSettings settings) {
        minimumEntropyTextbox.setText(String.valueOf(settings.getMinimumEntropy()));
        minimumFileSizeTextbox.setText(String.valueOf(settings.getMinimumFileSize() / MEGABYTE_SIZE));
        fileSizeMultiplesEnforcedCheckbox.setSelected(settings.isFileSizeMultipleEnforced());
        slackFilesAllowedCheckbox.setSelected(settings.isSlackFilesAllowed());
    }

    @Override
    public IngestModuleIngestJobSettings getSettings() {
        return new EncryptionDetectionIngestJobSettings(
                Double.valueOf(minimumEntropyTextbox.getText()),
                Integer.valueOf(minimumFileSizeTextbox.getText()) * MEGABYTE_SIZE,
                fileSizeMultiplesEnforcedCheckbox.isSelected(),
                slackFilesAllowedCheckbox.isSelected());
    }

    /**
     * Formatter to handle minimum entropy text input.
     */
    private final class MinimumEntropyTextFormatter extends DefaultFormatter {

        /**
         * Create an instance of the formatter.
         */
        MinimumEntropyTextFormatter() {
            super();
        }

        @Override
        public String valueToString(Object object) throws ParseException {
            return super.valueToString(object);
        }

        @Override
        public Object stringToValue(String string) throws ParseException {
            try {
                return Double.parseDouble(string);
            } catch (NumberFormatException ex) {
                logger.log(Level.WARNING, String.format("The text input '%s' for minimum entropy is not valid.", string), ex);
                /*
                 * Return a valid number outside the acceptable value range so
                 * it can be run through the validator in the file ingest
                 * module.
                 */
                return new Double(INVALID_TEXT_FIELD_INPUT_RETURN);
            }
        }
    }

    /**
     * Formatter to handle minimum file size text input.
     */
    private final class MinimumFileSizeTextFormatter extends DefaultFormatter {

        /**
         * Create an instance of the formatter.
         */
        MinimumFileSizeTextFormatter() {
            super();
        }

        @Override
        public String valueToString(Object object) throws ParseException {
            return super.valueToString(object);
        }

        @Override
        public Object stringToValue(String string) throws ParseException {
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException ex) {
                logger.log(Level.WARNING, String.format("The text input '%s' for minimum file size is not valid.", string), ex);
                /*
                 * Return a valid number outside the acceptable value range so
                 * it can still be run through the validator in the file ingest
                 * module.
                 */
                return INVALID_TEXT_FIELD_INPUT_RETURN;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        old_minimumEntropyTextbox = new javax.swing.JTextField();
        old_minimumFileSizeTextbox = new javax.swing.JTextField();
        fileSizeMultiplesEnforcedCheckbox = new javax.swing.JCheckBox();
        slackFilesAllowedCheckbox = new javax.swing.JCheckBox();
        minimumEntropyLabel = new javax.swing.JLabel();
        minimumFileSizeLabel = new javax.swing.JLabel();
        mbLabel = new javax.swing.JLabel();
        detectionSettingsLabel = new javax.swing.JLabel();
        minimumFileSizeTextbox = new javax.swing.JFormattedTextField();
        minimumEntropyTextbox = new javax.swing.JFormattedTextField();

        old_minimumEntropyTextbox.setText(org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.old_minimumEntropyTextbox.text")); // NOI18N

        old_minimumFileSizeTextbox.setText(org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.old_minimumFileSizeTextbox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(fileSizeMultiplesEnforcedCheckbox, org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.fileSizeMultiplesEnforcedCheckbox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(slackFilesAllowedCheckbox, org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.slackFilesAllowedCheckbox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(minimumEntropyLabel, org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.minimumEntropyLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(minimumFileSizeLabel, org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.minimumFileSizeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(mbLabel, org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.mbLabel.text")); // NOI18N

        detectionSettingsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(detectionSettingsLabel, org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.detectionSettingsLabel.text")); // NOI18N

        minimumFileSizeTextbox.setFormatterFactory(minimumFileSizeTextFormatterFactory);
        minimumFileSizeTextbox.setText(org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.minimumFileSizeTextbox.text")); // NOI18N
        minimumFileSizeTextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimumFileSizeTextboxActionPerformed(evt);
            }
        });

        minimumEntropyTextbox.setFormatterFactory(minimumEntropyTextFormatterFactory);
        minimumEntropyTextbox.setText(org.openide.util.NbBundle.getMessage(EncryptionDetectionIngestJobSettingsPanel.class, "EncryptionDetectionIngestJobSettingsPanel.minimumEntropyTextbox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slackFilesAllowedCheckbox)
                    .addComponent(detectionSettingsLabel)
                    .addComponent(fileSizeMultiplesEnforcedCheckbox)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(minimumEntropyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minimumEntropyTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(old_minimumEntropyTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minimumFileSizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minimumFileSizeTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(old_minimumFileSizeTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mbLabel)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detectionSettingsLabel)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(old_minimumEntropyTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimumEntropyLabel)
                    .addComponent(minimumEntropyTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(old_minimumFileSizeTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbLabel)
                    .addComponent(minimumFileSizeLabel)
                    .addComponent(minimumFileSizeTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileSizeMultiplesEnforcedCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slackFilesAllowedCheckbox)
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void minimumFileSizeTextboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimumFileSizeTextboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimumFileSizeTextboxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detectionSettingsLabel;
    private javax.swing.JCheckBox fileSizeMultiplesEnforcedCheckbox;
    private javax.swing.JLabel mbLabel;
    private javax.swing.JLabel minimumEntropyLabel;
    private javax.swing.JFormattedTextField minimumEntropyTextbox;
    private javax.swing.JLabel minimumFileSizeLabel;
    private javax.swing.JFormattedTextField minimumFileSizeTextbox;
    private javax.swing.JTextField old_minimumEntropyTextbox;
    private javax.swing.JTextField old_minimumFileSizeTextbox;
    private javax.swing.JCheckBox slackFilesAllowedCheckbox;
    // End of variables declaration//GEN-END:variables
}
