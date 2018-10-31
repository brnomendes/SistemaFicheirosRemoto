package pt.ipb.sd.cliente;

import pt.ipb.sd.interfaces.NavegadorRemote;

public class ClienteGUI extends javax.swing.JFrame {

    private final NavegadorRemote nr;

    public ClienteGUI(NavegadorRemote nr) {
        initComponents();
        this.nr = nr;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arvorePanel = new javax.swing.JScrollPane();
        arvore = new javax.swing.JTree();
        txtInfo = new javax.swing.JTextField();
        ficheiroPanel = new javax.swing.JScrollPane();
        txtFicheiro = new javax.swing.JTextArea();
        btnVoltar = new javax.swing.JButton();
        btnNovoFicheiro = new javax.swing.JButton();
        btnNovaPasta = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arvorePanel.setViewportView(arvore);

        txtFicheiro.setColumns(20);
        txtFicheiro.setRows(5);
        ficheiroPanel.setViewportView(txtFicheiro);

        btnVoltar.setText("Voltar");

        btnNovoFicheiro.setText("Novo Ficheiro");

        btnNovaPasta.setText("Nova Pasta");

        btnSalvar.setText("Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arvorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovoFicheiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovaPasta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addComponent(txtInfo)
                    .addComponent(ficheiroPanel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ficheiroPanel))
                    .addComponent(arvorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnNovoFicheiro)
                    .addComponent(btnNovaPasta)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arvore;
    private javax.swing.JScrollPane arvorePanel;
    private javax.swing.JButton btnNovaPasta;
    private javax.swing.JButton btnNovoFicheiro;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane ficheiroPanel;
    private javax.swing.JTextArea txtFicheiro;
    private javax.swing.JTextField txtInfo;
    // End of variables declaration//GEN-END:variables

}
