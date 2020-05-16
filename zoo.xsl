<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"

>

    <xsl:template match="/">
        <xsl:text>
create table Gatunek(
        nazwa varchar(30) primary key
        )

        create table Rzad(
        nazwa varchar(30) primary key,
        gatunek varchar(30) foreign key references Gatunek(nazwa)
        )

        create table Opiekun(
        id int primary key,
        Imie varchar(30),
        Nazwisko varchar(30)
        )
create table Zwierze (
        id int primary key identity,
        rzad varchar(30) foreign key references Rzad(nazwa),
        opiekun int foreign key references Opiekun(id),
        nazwa varchar(30),
        ilosc_m int,
        ilosc_f int,
        sredni_wzrost varchar(30),
        srednia_waga varchar(30)
        )
        </xsl:text>
                <xsl:apply-templates/>

    </xsl:template>

    <xsl:template match="zoo">
        <xsl:apply-templates select="gatunki"/>
        <xsl:apply-templates select="rzedy"/>
        <xsl:apply-templates select="opiekunowie"/>
        <xsl:apply-templates select="zwierzeta"/>

    </xsl:template>

    <xsl:template match="gatunki">
            <xsl:apply-templates select="gatunek"/>
    </xsl:template>

    <xsl:template match="gatunek">
            <xsl:text> insert into Gatunek values ('</xsl:text>

            <xsl:value-of select="."/>
            <xsl:text>')
            </xsl:text>

    </xsl:template>

    <xsl:template match="rzedy">
        <xsl:apply-templates select="rzad"/>
    </xsl:template>

    <xsl:template match="rzad">
        <xsl:text> insert into Rzad values ('</xsl:text>

        <xsl:value-of select="."/>
        <xsl:text>', '</xsl:text>
        <xsl:value-of select="@gatunek"/>
        <xsl:text>')
            </xsl:text>

    </xsl:template>

    <xsl:template match="opiekunowie">
        <xsl:apply-templates select="opiekun"/>
    </xsl:template>

    <xsl:template match="opiekun">
        <xsl:text> insert into Opiekun values (</xsl:text>

        <xsl:value-of select="@id"/>
        <xsl:text>, '</xsl:text>
        <xsl:value-of select="imie"/>
        <xsl:text>', '</xsl:text>
        <xsl:value-of select="nazwisko"/>
        <xsl:text>')
            </xsl:text>

    </xsl:template>


    <xsl:template match="zwierzeta">
        <xsl:apply-templates select="zwierze"/>
    </xsl:template>

    <xsl:template match="zwierze">
        <xsl:text> insert into Zwierze values ('</xsl:text>

        <xsl:value-of select="@rzad"/>
        <xsl:text>', </xsl:text>
        <xsl:value-of select="@opiekun"/>
        <xsl:text>, '</xsl:text>
        <xsl:value-of select="nazwa"/>
        <xsl:text>', </xsl:text>
        <xsl:value-of select="ilosc[@plec='m']"/>
        <xsl:text>, </xsl:text>
        <xsl:value-of select="ilosc[@plec='f']"/>
        <xsl:text>, '</xsl:text>
        <xsl:value-of select="sredni_wzrost"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="sredni_wzrost/@jednostka_wzrostu"/>
        <xsl:text>', '</xsl:text>
        <xsl:value-of select="srednia_waga"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="srednia_waga/@jednostka_wagi"/>
        <xsl:text>')
            </xsl:text>

    </xsl:template>

</xsl:stylesheet>