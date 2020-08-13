package wtf.violet.necessities.command;

import wtf.violet.common.command.BaseCommand;
import wtf.violet.necessities.Necessities;

import java.lang.reflect.InvocationTargetException;

public abstract class NessBaseCommand extends BaseCommand<Necessities>
{

    public NessBaseCommand(
        final Necessities ness,
        final String description,
        final String usage,
        final String permission,
        final String... aliases
    )
    {
        super(ness, description, usage, permission, getAliases(aliases));
    }

    @Override
    public void register()
        throws ClassNotFoundException,
        NoSuchMethodException,
        InvocationTargetException,
        IllegalAccessException
    {
        super.register();

        getPlugin()
            .getLogger()
            .info("Commands > Command /" + getName() + " registered successfully!");
    }

    private static String[] getAliases(final String... aliases)
    {
        final String[] next = new String[(aliases.length * 2)];

        int i = 0;

        for (final String alias : aliases)
        {
            next[i] = alias;
            next[i + 1] = "n" + alias;
            i += 2;
        }

        return next;
    }

}
