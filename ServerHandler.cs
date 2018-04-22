/** Kurs 1770 - Betriebliche Informationssysteme
    Implementierung des Server/Handler-Konzepts
    Erstellt :  27.05.2003
    Ersteller:  Jens Zimmermann
    Bearbeitet: 20.04.2008
    Bearbeiter:	Jens Zimmermann */

using System;
using System.Threading;

namespace ServerHandler
{

    public class Server
    {

        public Server()
        {
            new Thread(new ThreadStart(run)).Start();
        }

        public void run()
        {
            while (true)
            {
                Console.WriteLine("Waiting for new task");
                Console.ReadLine();
                Handler handler = new Handler();
                Console.WriteLine("New handler started");
                Thread.Sleep(1);
            }
        }

        [STAThread]
        static void Main(string[] args)
        {

            new Server();

        }
    }

    public class Handler
    {
        public Handler()
        {
            new Thread(new ThreadStart(runHandler)).Start();
        }


        public void runHandler()
        {
            Console.WriteLine("handling started");
            Thread.Sleep(3000);
            Console.WriteLine("handling finished");
        }

    }
}