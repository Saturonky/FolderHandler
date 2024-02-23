package java.org.exercise.Test;/*
package org.exercise.Test;

import com.generali.leonardo.contract.validation.DenunciaPut;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Denuncia {

    @Null(message = "Field \"denunciaId\" must be null", groups = {DenunciaPut.class, Default.class})
    private String denunciaId;

    @NotNull(message = "Field \"idoneitaIdColpita\" is required", groups = {DenunciaPut.class, Default.class})
    private String idoneitaIdColpita;

    @NotBlank(message = "Field \"mandanteId\" cannot be blank", groups = {DenunciaPut.class, Default.class})
    private String mandanteId;

    @NotBlank(message = "Field \"codPolizza\" cannot be blank", groups = {DenunciaPut.class, Default.class})
    private String codPolizza;

    @NotNull(message = "Field \"codTipoDenuncia\" is required", groups = {DenunciaPut.class, Default.class})
    private Long codTipoDenuncia;

    private String numeroFattura;

    private LocalDate dataFattura;

    @NotNull(message = "Field \"importoFattura\" is required", groups = {DenunciaPut.class, Default.class})
    private BigDecimal importoFattura;

    private String partitaIvaEmittente;

    private String codiceFiscaleEmittente;

    private String descEmittente;

    private String soggettoIdEmittente;

    private String soggettoIdBeneficiario;

    private String ibanBeneficiario;

    @NotNull(message = "Field \"codStatoDenuncia\" is required", groups = {DenunciaPut.class, Default.class})
    private Long codStatoDenuncia;

    @NotNull(message = "Field \"dataApertura\" is required", groups = {DenunciaPut.class, Default.class})
    private OffsetDateTime dataApertura;

    private String sottoprestazioneId;

    private LocalDate dataPrestazione;

    private LocalDate dataEvento;

    private BigDecimal importoEnte;

    private Boolean idcEmittenteEstero;

    private LocalDate dataInizioRicovero;

    private LocalDate dataFineRicovero;

    @Valid
    private DenunciationSource denunciaSource;

    private Boolean idcSpa;

    private Boolean idcPrivacy;

    @Valid
    private GestoreStoria gestoreStoria;

    private LocalDate dataDenuncia;
    private LocalDate dataPervenimentoDenuncia;
    private String codTipoPratica;
    private Boolean idcCicloCure;
    private String sinistroId;
}*/
