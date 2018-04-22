/** Kurs 1770 - Betriebliche Informationssysteme
    Implementierung des Asynchronen Aufrufs
    Erstellt :  27.05.2003
    Ersteller:  Jens Zimmermann
    Bearbeitet: 20.04.2008
    Bearbeiter:	Jens Zimmermann */

using System;
using System.Threading;

namespace AsynchronerAufruf
{

    public class Client
    {

        public Client()
        {
            Caller caller = new Caller(null);
            while (caller.returned() == false)
            {
                Console.WriteLine("Do some other work...");
                Thread.Sleep(1000);
            }

            Console.WriteLine("Continue with result");

            Caller caller2 = new Caller(this);
            Console.WriteLine("Do lots of other work");
        }

        [STAThread]
        static void Main(string[] args)
        {
            new Client();
        }

        public void callback()
        {
            Console.WriteLine("Received result");
        }
    }



    public class Caller
    {
        Client client;
        bool finished;

        public Caller(Client client)
        {
            this.client = client;
            finished = false;
            new Thread(new ThreadStart(doWork)).Start();
        }

        private void doWork()
        {
            Console.WriteLine("start work");
            Thread.Sleep(3500);
            Console.WriteLine("end work");

            finished = true;

            if (client == null)
                client.callback();
        }

        public bool returned()
        {
            return finished;
        }

    }
}
