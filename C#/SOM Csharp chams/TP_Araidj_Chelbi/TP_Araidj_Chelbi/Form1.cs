using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;
using AForge.Neuro;
using AForge.Neuro.Learning;
using System.Threading;

namespace TP_Araidj_Chelbi
{
    public partial class Form1 : Form
    {
        OleDbConnection odbc;
        OleDbDataAdapter odbda;
        DataTable dt2 = null;
        string filepath = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=";
        string ep = ";Extended Properties=\"Excel 8.0;HDR=YES;\"";
        DistanceNetwork dn;
        SOMLearning trainer;
        bool b = false;
        double[] input;
        public int[] wnv;
        public delegate void Updateprogressbar(int ni);
        Thread th;
        public Form1()
        {
            InitializeComponent();
        }





        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog dlg = new OpenFileDialog();
            dlg.Title = "Open Photo";
            dlg.Filter = "xls files (*.xls)|*.xls|All files (*.*)|*.*";
            if (dlg.ShowDialog() == DialogResult.OK)
            {
                dt2 = new DataTable();
                odbc = new OleDbConnection(filepath + dlg.FileName + ep);
                odbda = new OleDbDataAdapter("Select *  from [Feuil1$]", odbc);
                odbda.Fill(dt2);
                dt2.Columns.Remove("Jour");
                this.textBox1.Text = dlg.FileName;
                this.textBox2.Text = dt2.Columns.Count.ToString();
            }
            dlg.Dispose();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            dn = new DistanceNetwork(int.Parse(textBox2.Text), int.Parse(textBox3.Text));
            trainer = new SOMLearning(dn);
            wnv = new int[int.Parse(textBox3.Text)];
            input = new double[int.Parse(textBox2.Text)];
            trainer.LearningRadius = int.Parse(textBox5.Text);
            trainer.LearningRate = double.Parse(textBox4.Text);
            th = new Thread(new ThreadStart(Commencer));
            th.Start();
        }

        public void Commencer()
        {
            for (int k = 0; k < dt2.Rows.Count; k++) 
            {
                input = this.getRow(k);
                trainer.Run(input);
                wnv[dn.GetWinner()]++;
                this.Invoke((Updateprogressbar)updateg,100*(k+1)/dt2.Rows.Count);
            }

        }

        public void updateg(int i){

            this.progressBar1.Value = i;
        }

        public double[] getRow(int i)
        {
            int n = this.dt2.Columns.Count;
            double[] arr = new double[n];
            DataRow dr = this.dt2.Rows[i];
            for (int j = 0; j < n; j++) arr[j] = dr.Field<double>(j);
            return arr;
        }

        private void button3_Click(object sender, EventArgs e)
        {

            if (th != null) if (b == true) { th.Suspend(); button3.Text = "Continue"; } else { th.Resume(); button3.Text = "Stop"; }
                b = !b;

            
        }
    }
}