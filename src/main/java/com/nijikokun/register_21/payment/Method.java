package com.nijikokun.register_21.payment;

import org.bukkit.plugin.Plugin;

/**
 * Interface to be implemented by a payment method.
 *
 * @author Nijikokun <nijikokun@shortmail.com> (@nijikokun)
 * @copyright Copyright (C) 2011
 * @license AOL license <http://aol.nexua.org>
 */
public interface Method {
    /**
     * Encodes the Plugin into an Object disguised as the Plugin.
     * If you want the original Plugin Class you must cast it to the correct
     * Plugin, to do so you have to verify the name and or version then cast.
     *
     * <pre>
     *  if(method.getName().equalsIgnoreCase("iConomy"))
     *   iConomy plugin = ((iConomy)method.getPlugin());</pre>
     * 
     * @return <code>Object</code>
     * @see #getName()
     * @see #getVersion()
     */
    public Object getPlugin();

    /**
     * Returns the actual name of this method.
     *
     * @return <code>String</code> Plugin name.
     */
    public String getName();

    /**
     * Returns the actual version of this method.
     *
     * @return <code>String</code> Plugin version.
     */
    public String getVersion();


    /**
     * Formats amounts into this payment methods style of currency display.
     *
     * @param amount Double
     * @return <code>String</code> - Formatted Currency Display.
     */
    public String format(double amount);

    /**
     * Allows the verification of bank API existence in this payment method.
     *
     * @return <code>boolean</code>
     */
    public boolean hasBanks();

    /**
     * Determines the existence of a bank via name.
     *
     * @param bank Bank name
     * @return <code>boolean</code>
     * @see #hasBanks
     */
    public boolean hasBank(String bank);

    /**
     * Determines the existence of an account via name.
     *
     * @param name Account name
     * @return <code>boolean</code>
     */
    public boolean hasAccount(String name);

    /**
     * Check to see if an account <code>name</code> is tied to a <code>bank</code>.
     *
     * @param bank Bank name
     * @param name Account name
     * @return <code>boolean</code>
     */
    public boolean hasBankAccount(String bank, String name);

    /**
     * Returns a <code>MethodAccount</code> class for an account <code>name</code>.
     *
     * @param name Account name
     * @return <code>MethodAccount</code> <em>or</em>  <code>Null</code>
     */
    public MethodAccount getAccount(String name);


    /**
     * Returns a <code>MethodBankAccount</code> class for an account <code>name</code>.
     *
     * @param bank Bank name
     * @param name Account name
     * @return <code>MethodBankAccount</code> <em>or</em>  <code>Null</code>
     */
    public MethodBankAccount getBankAccount(String bank, String name);

    /**
     * Checks to verify the compatibility between this Method and a plugin.
     * Internal usage only, for the most part.
     *
     * @param plugin Plugin
     * @return <code>boolean</code>
     */
    public boolean isCompatible(Plugin plugin);

    /**
     * Set Plugin data.
     *
     * @param plugin Plugin
     */
    public void setPlugin(Plugin plugin);

    /**
     * Contains Calculator and Balance functions for Accounts.
     */
    public interface MethodAccount {
        public double balance();
        public boolean set(double amount);
        public boolean add(double amount);
        public boolean subtract(double amount);
        public boolean multiply(double amount);
        public boolean divide(double amount);
        public boolean hasEnough(double amount);
        public boolean hasOver(double amount);
        public boolean hasUnder(double amount);
        public boolean isNegative();
        public boolean remove();

        @Override
        public String toString();
    }

    /**
     * Contains Calculator and Balance functions for Bank Accounts.
     */
    public interface MethodBankAccount {
        public double balance();
        public String getBankName();
        public int getBankId();
        public boolean set(double amount);
        public boolean add(double amount);
        public boolean subtract(double amount);
        public boolean multiply(double amount);
        public boolean divide(double amount);
        public boolean hasEnough(double amount);
        public boolean hasOver(double amount);
        public boolean hasUnder(double amount);
        public boolean isNegative();
        public boolean remove();

        @Override
        public String toString();
    }
}
