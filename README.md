# 键盘命令

## 简介

本模组允许玩家自定义一个按键并且绑定一个命令.

需要在服务端也安装本模组 并且只有服务端也有**完全一样**的自定义命令时才能执行命令.

当玩家处在多人游戏时,执行的命令无视玩家是否有op,只要服务端允许 可以执行玩家本不能执行的命令.

当玩家处在单机模式时,能执行的命令由玩家本身权限决定.

## 使用方法

在第一次启动游戏时(或者你可以自己创建), 会在 `/.minecraft/config/key_command` 文件夹下生成 `config.json` 文件, 该文件的内容需要你手动输入.

```json
// 示例文件.
{
  "key_array" : [
    {
      "command": "kill @s",
      "default_key": 47
    },
    {
      "command": "tp @e ~ ~ ~",
      "default_key": 199,
      "fake_player" : false
    }
  ]
}
```

你只需要在 `key_array` 中增加 `jsonObject` 即可, 其中`jsonObject` 有三个参数:

-  `command` ：后接一个字符串 (string), 表示需要执行的命令, 不需要 `/`.

-  `default_key` ：后接一个整型数字 (int), 表示默认绑定的按键, 点击即可查看按键与数字对照表 [点击跳转](https://i.mcmod.cn/editor/upload/20230702/1688305262_52555_FCmg.png). (请注意所有数字均为十六进制, 在填写json时请自行将其转换为十进制)

-  `fake_player` ：可选项, 若不填默认值为true, 表示命令的执行者是不是玩家(默认不是由玩家执行，部分命令可能无法正常执行，但是这样可以让服务器执行一些玩家本没有权限的命令). (这样设计的原因是, 作者认为,  `/forge_tps` 一类的命令不应该需要作弊权限).

***

# KeyCommand

## Introduction

This mod allows players to customize a key and bind a command.

This mod needs to be installed on both side and only the server side also has **Exactly The Same** command key bind, it can be executed.

When the player is in a multiplayer game, the executed command ignores whether the player has op or not, as long as the server allows it to execute commands that the player cannot execute.

When the player is in single player game,the commands can be executed or not are determined by the player's own authority.

## Usage

When you first launch the game (or you can create it by yourself), a `config.json` file will be generated in the `/.minecraft/config/key_command` folder, you need to enter the contents of this file manually.

```json
// The Example File.
{
  "key_array" : [
    {
      "command": "kill @s",
      "default_key": 47
    },
    {
      "command": "tp @e ~ ~ ~",
      "default_key": 199,
      "fake_player" : false
    }
  ]
}
```

You just need to add `jsonObject` to `key_array`, where `jsonObject` has three parameters.

- `command`: followed by a string, indicating the command to be executed, no need  `/`.

- `default_key`: followed by an integer number, indicating the default key binding, click on it to see the key number comparison table [Click to jump](https://i.mcmod.cn/editor/upload/20230702/1688305262_52555_FCmg.png). (Please notice that all numbers are in hexadecimal, so please convert them to decimal when you fill in the json)

- `fake_player`: optional, if not filled the default value is true, indicating whether the command is executed by the player or not (the default is not executed by the player, some commands may not be executed properly, but this allows the server to execute some commands that the player does not have no permission to execute). (The reason why, this design is that the author believes that commands like `/forge_tps` ought not to require cheat permmision).
