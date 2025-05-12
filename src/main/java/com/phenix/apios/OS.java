/*
 * Licence Studio l'Equipe.
 */
package com.phenix.apios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

/**
 * Gestion des informations OS.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public enum OS {
    /**
     * Nom de l'OS Windows.
     */
    WINDOWS("win"),
    /**
     * Nom de l'OS Mac.
     */
    MACOSX("Mac OS X"),
    /**
     * @deprecated Pas encore définit.
     */
    LINUX("XXX");

    /**
     * Valeur de comparaison utilisée.
     */
    @NotNull
    @NotBlank
    public final String valeur;

    /**
     * Définit la valeur de gestion pour un OS.
     *
     * @param valeur La valeur.
     */
    private OS(@NotNull @NotBlank String valeur) {
        this.valeur = valeur;
    }

    /**
     * Retourne l'enum OS de l'ordinateur où est instancié le programme.
     *
     * @return L'OS.
     */
    @Null
    public static OS fromOSName() {
        String nomOs = getOS();
        if (isWindows(nomOs)) {
            return WINDOWS;
        } else if (isMacOSX(nomOs)) {
            return MACOSX;
        } else {
            return null;
        }
    }

    /**
     * Retourne le nom de l'OS sur lequel on est.
     *
     * @return Nom de l'OS.
     */
    @NotNull
    public static String getOS() {
        return System.getProperty("os.name");
    }

    /**
     * Retourne {@code true} si l'ordinateur où est lancé le programme est un
     * macOS X.
     *
     * @return {@code true} si c'est un macOS X.
     */
    public static boolean isMacOSX() {
        return isMacOSX(getOS());
    }

    /**
     * Retourne {@code true} si le nom de l'OS est macOS X.
     *
     * @param nomOs Nom de l'OS (normalement
     * {@code System.getProperty("os.name");}).
     * @return {@code true} si c'est macOS X.
     */
    public static boolean isMacOSX(String nomOs) {
        return MACOSX.valeur.equals(nomOs);
    }

    /**
     * Retourne {@code true} si l'ordinateur où est lancé le programme est un
     * Windows.
     *
     * @return {@code true} si c'est Windows.
     */
    public static boolean isWindows() {
        return isWindows(getOS());
    }

    /**
     * Retourne {@code true} si le nom de l'OS est Windows.
     *
     * @param nomOs Nom de l'OS (normalement
     * {@code System.getProperty("os.name");}).
     * @return {@code true} si c'est Windows.
     */
    public static boolean isWindows(@NotNull String nomOs) {
        return nomOs.toLowerCase().contains(WINDOWS.valeur);
    }
}
