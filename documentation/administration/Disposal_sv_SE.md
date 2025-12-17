# Gallring

## Gallringsschema

Se [Gallringsspolicyer](#theme/administration/Disposal_Policies_sv_SE.md) för mer information om gallringsscheman.

### Konfigurera ETERNA för att fält ska överensstämma

För att identifierade element ska överensstämma populeras de genom att använda avancerad sökning. De fält som har `date_interval` som typ, kommer väljas och användas för att beräkna tidsfrist för perioden. 
Gå till [Avancerad Sökning](#theme/usage/Advanced_Search_sv_SE.md) för mer information om hur man lägger till nya fält. 

## Gallringsregel

Se [Gallringsspolicyer](#theme/administration/Disposal_Policies_sv_SE.md) för mer information om gallringsregler.

### Konfigurera ETERNA för att visa fält i urvalsmetoden 'metadatafält'

Metadatafältet finns under det avancerade sökfältet. Här kan fält som är av `text`-typ väljas. ETERNA kan konfigureras för att utesluta vissa av dessa fält, vilket görs genom att lägga till en ny lista för icke-godkända metadata i din `roda-wui.properties`. Som standard visar ETERNA all metadata av typen `text`.

```javaproperties
ui.disposal.rule.blacklist.condition = description
```

Se [Avancerad Sökning](#theme/usage/Advanced_Search_sv_SE.md) för mer information om hur du lägger till ett nytt avancerat sökfält.

Se [Metadata Format](#theme/reference/Metadata_Formats_sv_SE.md) för mer information om beskrivande metadatakonfiguration i ETERNA.
