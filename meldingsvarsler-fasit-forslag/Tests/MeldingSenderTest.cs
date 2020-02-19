using System;
using System.Collections.Generic;
using System.Linq;
using App;
using Xunit;

namespace Tests
{
    public class MeldingSenderTest
    {
        readonly MeldingRepositoryStub meldingRepositoryStub;
        readonly AbonnentRepositoryStub abonnentRepositoryStub;
        readonly IMeldingRepository meldingRepositoryReader;
        readonly IAbonnentRepositoryReader abonnentRepositoryReader;
        readonly IAbonnentRepositoryStatistikk abonnentRepositoryStatistikk;
        readonly List<IMeldingProsessor> meldingProsessorer;
        readonly MeldingSender meldingSender;

        public MeldingSenderTest()
        {
            meldingProsessorer = new List<IMeldingProsessor>();
            abonnentRepositoryStub = new AbonnentRepositoryStub();
            meldingRepositoryStub = new MeldingRepositoryStub();
            abonnentRepositoryStatistikk = abonnentRepositoryStub;
            abonnentRepositoryReader = abonnentRepositoryStub;
            meldingRepositoryReader = meldingRepositoryStub;
            meldingSender = new MeldingSender(meldingRepositoryReader, abonnentRepositoryReader, meldingProsessorer);

            IAbonnentRepositoryWriter abonnentRepositoryWriter = abonnentRepositoryStub;
            IMeldingRepositoryWriter meldingRepositoryWriter = meldingRepositoryStub;

            meldingProsessorer.Add(new EpostProsessor());
            meldingProsessorer.Add(new FacebookProsessor());
            meldingProsessorer.Add(new SmsProsessor());

            meldingRepositoryWriter.LeggTilMelding(
                new SmsMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!"));
            meldingRepositoryWriter.LeggTilMelding(new EpostMelding("Løp og kjøp. Førstemann til mølla!!",
                                                                    "Vårens kleskolleksjon har kommet. "));
            meldingRepositoryWriter.LeggTilMelding(
                new FacebookMelding(
                    "Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!! Del på Facebook."));

            abonnentRepositoryWriter.LeggTilAbonnent(new SmsAbonnent("Per Hansen", "90965253"));
            abonnentRepositoryWriter.LeggTilAbonnent(new SmsAbonnent("Mohammed Normann", "77881111"));
            abonnentRepositoryWriter.LeggTilAbonnent(new SmsAbonnent("Per Abdullah", "77881111"));
            abonnentRepositoryWriter.LeggTilAbonnent(new SmsAbonnent("Knut Pettersen", "7766555"));
            abonnentRepositoryWriter.LeggTilAbonnent(new EpostAbonnent("Per Hansen", "per@epost.no"));
            abonnentRepositoryWriter.LeggTilAbonnent(new EpostAbonnent("Kari Normann", "kari.normann@epost.no"));
            abonnentRepositoryWriter.LeggTilAbonnent(new FacebookAbonnent("Per Hansen", "per@eepost.no"));
        }

        [Fact]
        public void SendMeldingerTest()
        {
            meldingSender.SendMeldinger();
        }

        [Fact]
        public void Statistikk()
        {
            abonnentRepositoryReader.HentAbonnenter()
                                     .Select(abonnent => abonnent.GetType())
                                     .Distinct()
                                     .ToList()
                                     .ForEach(type =>
                                                  Console.Out.WriteLine(
                                                      type.Name + ":" + abonnentRepositoryStatistikk
                                                          .AntallAbonnererPaa(type)
                                                  ));
        }
    }
}