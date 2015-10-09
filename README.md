# FitRepair

FIT file power data repair tool which Invalid power data fix to zero.

# What is this?

<img src="https://raw.githubusercontent.com/harry0000/FitRepair/master/images/invalid_power.png" alt="Invalid power at the start pedaling" />

When [ROTOR Power meter](http://rotorbike.com/products/road/power_198) use, there is an invalid power value is recorded on a cycle computer at the start pedaling.

<img src="https://raw.githubusercontent.com/harry0000/FitRepair/master/images/fix_image.png" alt="fix image" />

This tool fix the power that has spiked to zero.

# Projects

## fitrepair-main

Main source code of repair tool.

- FitRepair
  - Main class

- Checker
  - Pick up the record that power has spiked at the start pedaling.

- Repair
  - Fix spiking power to zero.
  - Update accumulated power.
  - Update max power.
  - Update average power.

## fitrepair-utils

The reinvention of FIT SDK for activity fit file.

Ant+ FIT SDK - http://www.thisisant.com/resources/fit

Simple use cases

```java
final Reader reader = new Reader();
reader.getDispatcher().setHeaderLintener(
    (header) -> {
        // do something.
    });

reader.getDispatcher().setDefinitionMsgListener(
    (defMsg) -> {
        // do something.
    });

reader.getDispatcher().setDataMsgListener(
    (defMsg, msg) -> {
        // do something.
    });

final boolean result;
try (final InputStream in = new FileInputStream(fitFile)) {
    result = reader.read(in);
} catch (final IOException e) {
    logger.error("Error while reading fit file.", e);
    return;
} finally {
    reader.getDispatcher().removeListeners();
}
```

# How to build

You will need to install JDK 8.

```
> git clone https://github.com/harry0000/FitRepair.git
> cd FitRepair
> gradlew jar
```

# How to use

```
> java -jar FitRepair.jar C:\path\to\fitfile.fit
```

# TODO

## fitrepair-utils

- [ ] Write javadoc
- [ ] Implement other messages & listeners
- [ ] Add timestamp offset tests
- [ ] Move to 'fit-utils' repository
- [ ] Porting to C#

#LICENSE

MIT
