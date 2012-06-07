/***
 * Copyright (c) 2008, Mariano Rodriguez-Muro.
 * All rights reserved.
 *
 * The OBDA-API is licensed under the terms of the Lesser General Public
 * License v.3 (see OBDAAPI_LICENSE.txt for details). The components of this
 * work include:
 * 
 * a) The OBDA-API developed by the author and licensed under the LGPL; and, 
 * b) third-party components licensed under terms that may be different from 
 *   those of the LGPL.  Information about such licenses can be found in the 
 *   file named OBDAAPI_3DPARTY-LICENSES.txt.
 */

package it.unibz.krdb.obda.gui.swing.panel;

import it.unibz.krdb.obda.gui.swing.IconLoader;
import it.unibz.krdb.obda.gui.swing.treemodel.IncrementalResultSetTableModel;
import it.unibz.krdb.obda.gui.swing.utils.DatasourceSelectorListener;
import it.unibz.krdb.obda.gui.swing.utils.OBDAProgessMonitor;
import it.unibz.krdb.obda.gui.swing.utils.OBDAProgressListener;
import it.unibz.krdb.obda.model.OBDADataSource;
import it.unibz.krdb.sql.JDBCConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQLQueryPanel extends javax.swing.JPanel implements DatasourceSelectorListener {

	private static final long serialVersionUID = 7600557919206933923L;

	private Logger log = LoggerFactory.getLogger(SQLQueryPanel.class);

	private OBDADataSource selectedSource;

	/**
	 * Creates new form SQLQueryPanel
	 */
	public SQLQueryPanel() {
		initComponents();
	}

	public SQLQueryPanel(OBDADataSource ds, String query) {
		initComponents();
		txtSqlQuery.setText(query);
		selectedSource = ds;
		cmdExecuteActionPerformed(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        splSqlQuery = new javax.swing.JSplitPane();
        pnlSqlQuery = new javax.swing.JPanel();
        scrSqlQuery = new javax.swing.JScrollPane();
        txtSqlQuery = new javax.swing.JTextArea();
        cmdExecute = new javax.swing.JButton();
        pnlQueryResult = new javax.swing.JPanel();
        scrQueryResult = new javax.swing.JScrollPane();
        tblQueryResult = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("SQL Query"));
        setAlignmentX(5.0F);
        setAlignmentY(5.0F);
        setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 480));
        setLayout(new java.awt.BorderLayout(5, 5));

        splSqlQuery.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splSqlQuery.setResizeWeight(0.3);
        splSqlQuery.setNextFocusableComponent(cmdExecute);

        pnlSqlQuery.setMinimumSize(new java.awt.Dimension(156, 100));
        pnlSqlQuery.setPreferredSize(new java.awt.Dimension(156, 100));
        pnlSqlQuery.setLayout(new java.awt.GridBagLayout());

        scrSqlQuery.setPreferredSize(new java.awt.Dimension(600, 100));

        txtSqlQuery.setColumns(20);
        txtSqlQuery.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtSqlQuery.setLineWrap(true);
        txtSqlQuery.setRows(2);
        txtSqlQuery.setBorder(null);
        txtSqlQuery.setNextFocusableComponent(cmdExecute);
        txtSqlQuery.setPreferredSize(new java.awt.Dimension(600, 100));
        scrSqlQuery.setViewportView(txtSqlQuery);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        pnlSqlQuery.add(scrSqlQuery, gridBagConstraints);

        cmdExecute.setIcon(IconLoader.getImageIcon("images/execute.png"));
        cmdExecute.setMnemonic('x');
        cmdExecute.setText("Execute");
        cmdExecute.setToolTipText("Execute the SQL query");
        cmdExecute.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cmdExecute.setContentAreaFilled(false);
        cmdExecute.setMargin(new java.awt.Insets(5, 14, 5, 14));
        cmdExecute.setMaximumSize(new java.awt.Dimension(85, 25));
        cmdExecute.setMinimumSize(new java.awt.Dimension(85, 25));
        cmdExecute.setPreferredSize(new java.awt.Dimension(85, 25));
        cmdExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExecuteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        pnlSqlQuery.add(cmdExecute, gridBagConstraints);

        splSqlQuery.setLeftComponent(pnlSqlQuery);

        pnlQueryResult.setLayout(new java.awt.BorderLayout());

        tblQueryResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Results"
            }
        ));
        tblQueryResult.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrQueryResult.setViewportView(tblQueryResult);

        pnlQueryResult.add(scrQueryResult, java.awt.BorderLayout.CENTER);

        splSqlQuery.setRightComponent(pnlQueryResult);

        add(splSqlQuery, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

	private void cmdExecuteActionPerformed(java.awt.event.ActionEvent evt) {
		releaseResultset();
		try {
			if (selectedSource == null) {
				JOptionPane.showMessageDialog(this, "Please select data source first", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				OBDAProgessMonitor progMonitor = new OBDAProgessMonitor("Executing query...");
				CountDownLatch latch = new CountDownLatch(1);
				ExecuteSQLQueryAction action = new ExecuteSQLQueryAction(latch);
				progMonitor.addProgressListener(action);
				progMonitor.start();
				action.run();
				latch.await();
				progMonitor.stop();
				ResultSet set = action.getResult();
				if (set != null) {
					IncrementalResultSetTableModel model = new IncrementalResultSetTableModel(set);
					tblQueryResult.setModel(model);
					set.close();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			log.error("Error while executing query.", e);
		}

	}

	private void releaseResultset() {
		TableModel model = tblQueryResult.getModel();
		if (model == null)
			return;
		if (!(model instanceof IncrementalResultSetTableModel))
			return;
		IncrementalResultSetTableModel imodel = (IncrementalResultSetTableModel) model;
		imodel.close();

	}

	@Override
	public void datasourceChanged(OBDADataSource oldSource, OBDADataSource newSource) {
		this.selectedSource = newSource;
		releaseResultset();
	}

	@Override
	public void finalize() {
		releaseResultset();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdExecute;
    private javax.swing.JPanel pnlQueryResult;
    private javax.swing.JPanel pnlSqlQuery;
    private javax.swing.JScrollPane scrQueryResult;
    private javax.swing.JScrollPane scrSqlQuery;
    private javax.swing.JSplitPane splSqlQuery;
    private javax.swing.JTable tblQueryResult;
    private javax.swing.JTextArea txtSqlQuery;
    // End of variables declaration//GEN-END:variables

	private class ExecuteSQLQueryAction implements OBDAProgressListener {

		CountDownLatch latch = null;
		Thread thread = null;
		ResultSet result = null;
		Statement statement = null;

		private ExecuteSQLQueryAction(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void actionCanceled() throws SQLException {
			if (thread != null) {
				thread.interrupt();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			result = null;
			latch.countDown();
		}

		public ResultSet getResult() {
			return result;
		}

		public void run() {
			thread = new Thread() {
				public void run() {
					try {
						TableModel oldmodel = tblQueryResult.getModel();

						if ((oldmodel != null) && (oldmodel instanceof IncrementalResultSetTableModel)) {
							IncrementalResultSetTableModel rstm = (IncrementalResultSetTableModel) oldmodel;
							rstm.close();
						}
						JDBCConnectionManager man = JDBCConnectionManager.getJDBCConnectionManager();
						Connection c = man.getConnection(selectedSource);
						Statement s = c.createStatement();
						result = s.executeQuery(txtSqlQuery.getText());
						latch.countDown();
					} catch (Exception e) {
						latch.countDown();
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						log.error("Error while executing query.", e);
					}
				}
			};
			thread.start();
		}

	}
}
