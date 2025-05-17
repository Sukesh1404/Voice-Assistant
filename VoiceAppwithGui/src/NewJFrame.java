import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;
import javax.swing.JOptionPane;

public class NewJFrame extends javax.swing.JFrame {

private LiveSpeechRecognizer recognizer;
private Thread recognitionThread;
private boolean recognizing = false;

    public NewJFrame() {
        initComponents();
//        jButton1.addActionListener(e -> startRecognition());
//        jButton2.addActionListener(e -> stopRecognition());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Voice Assistant");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Status : Stopped");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Commands :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        startRecognition();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        stopRecognition();
    }//GEN-LAST:event_jButton2ActionPerformed
     
    private void initRecognizer() throws IOException {
    Configuration config = new Configuration();
//    config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
//    config.setDictionaryPath("src\\resources\\8188.dic");
//    config.setLanguageModelPath("src\\resources\\8188.lm");
    
    config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    config.setDictionaryPath("resource:/resources/8188.dic");
    config.setLanguageModelPath("resource:/resources/8188.lm");

    recognizer = new LiveSpeechRecognizer(config);
    }

    private void startRecognition() {
        if (recognizing) {
            System.out.println("Already recognizing...");
            return;
        }

        try {
            if (recognizer == null) {
                initRecognizer(); // Only initialize if null
            }
            recognizer.startRecognition(true);
            recognizing = true;

            jButton1.setEnabled(false);
            jButton2.setEnabled(true);
            jLabel2.setText("Status: Listening...");

            recognitionThread = new Thread(()->{execRecognitionLoop();});
            recognitionThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void execRecognitionLoop() {
        try {
            SpeechResult speechResult;
            while (recognizing && (speechResult = recognizer.getResult()) != null) {
                String voiceCommand = speechResult.getHypothesis();
                System.out.println("Voice Command: " + voiceCommand);

                jTextArea1.append("Voice Command: " + voiceCommand + "\n");

                try {
                    if (voiceCommand.equalsIgnoreCase("Hello INCAPP")) {
                        jTextArea1.append("HOW CAN I ASSIST YOU!! " + "\n");
                    }else if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
                        new ProcessBuilder("cmd.exe", "/c", "start", "chrome", "www.incapp.in").start();
                    } else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
                        new ProcessBuilder("taskkill", "/F", "/IM", "chrome.exe").start();
                    } else if (voiceCommand.equalsIgnoreCase("Open Notepad")) {
                        new ProcessBuilder("cmd.exe", "/c", "start", "notepad.exe").start();
                    } else if (voiceCommand.equalsIgnoreCase("Close Notepad")) {
                        new ProcessBuilder("taskkill", "/F", "/IM", "notepad.exe").start();
                    } else if (voiceCommand.equalsIgnoreCase("Open Eclipse")) {
                        new ProcessBuilder("C:\\Users\\incapp\\eclipse\\jee-2024-062\\eclipse\\eclipse.exe").start();
                    } else if (voiceCommand.equalsIgnoreCase("Close Eclipse")) {
                        new ProcessBuilder("taskkill", "/F", "/IM", "eclipse.exe").start();
                    } else if (voiceCommand.equalsIgnoreCase("Open NetBeans")) {
                        new ProcessBuilder("C:\\Program Files\\NetBeans-22\\netbeans\\bin\\netbeans64.exe").start();
                    } else if (voiceCommand.equalsIgnoreCase("Close NetBeans")) {
                        new ProcessBuilder("taskkill", "/F", "/IM", "netbeans64.exe").start();
                    } else if (voiceCommand.equalsIgnoreCase("System Shutdown")) {
                        new ProcessBuilder("shutdown", "-s", "-t", "0").start();
                    } else if (voiceCommand.equalsIgnoreCase("System Restart")) {
                        new ProcessBuilder("shutdown", "-r", "-t", "0").start();
                    } else {
                        System.out.println("Unrecognized Command: " + voiceCommand);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
//                    JOptionPane.showMessageDialog(null,ioException.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopRecognition() {
        if (!recognizing) {
            System.out.println("Recognition already stopped.");
            return;
        }

        recognizing = false;

        try {
            if (recognitionThread != null && recognitionThread.isAlive()) {
                recognitionThread.join();
            }
            if (recognizer != null) {
                recognizer.stopRecognition();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jLabel2.setText("Status: Stopped");
    }

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
