# poker-tdd

### single poker compare
```
Given:      a = "6C"   b = "TH"
Return:     b
```
### high poker
```
Given:      a = "2C 6S 5H 3D QS"    b = "KH 7H 6S 9D 3S"
Return:     b
```

### pair poker
``` 一个有对子，一个没对子
Given:      a = "2C 6S 5H 2D QS"    b = "KH 7H 6S 9D 3S"
Return:     a
```
``` 两个都是对子
Given:      a = "2C 6S 5H 6D QS"    b = "KH 7H 6S 3D 3S"
Return:     a
```
``` 两个都是对子且对子一样
Given:      a = "2C 3S 5H 3D QS"    b = "KH 7H 6S 3D 3S"
Return:     b
```

### two pair
``` 有两个对子
Given:      a = "2C 3S 5H 3D 5S"    b = "KH 5H 6S 3D 3S"
Return:     a
```

### three cards same
``` 三张牌一样 VS 一个对子
Given:      a = "2C 6S 5H 2D QS"    b = "KH 3H 6S 3D 3S"
Return:     b
```

### have straight
``` 有顺子
Given:      a = "2C 6S 5H 3D 4S"    b = "KH 3H 6S 3D 3S"
Return:     a
```

### have flush
``` 同花色
Given:      a = "2C 6S 5H 3D 4S"    b = "9H 2H 6H 5H 3H"
Return:     b
```
``` 同花色
Given:      a = "5H 3H 9H TH QH"    b = "9H 2H 6H 5H 3H"
Return:     a
```

### have full house
``` 三个相同，一个对子
Given:      a = "5H 3H 9H TH QH"   b = "6H 3H 6S 3D 3S"
Return:     b
```
``` 三个相同，一个对子
Given:      a = "5H 5S 9H 9D 9S"    b = "6H 3H 6S 3D 3S"
Return:     a
```

### have four of a kind
``` 四个相同的
Given:      a = "5H 9C 9H 9D 9S"    b = "6H 3H 6S 3D 3S"
Return:     a
```
``` 四个相同的
Given:      a = "5H 9C 9H 9D 9S"    b = "3H QC QH QD QS"
Return:     b
```

### straight flush
``` 同花顺
Given:      a = "5H 9C 9H 9D 9S"    b = "3S 4S 5S 6S 7S"
Return:     b
```
