import Data.List
import System.IO
--1
isOdd :: Int -> Bool
isOdd n
	| n `mod` 2 == 0 = False
	| otherwise = True
isEven n = n`mod` 2 == 0
--2
whatGrade :: Int -> String
whatGrade age 
	| (age >= 5) && (age <= 6) = "ca passe "
	| (age > 6) && (age <= 9) = "ca passe1 "
	| (age > 9) && (age <= 12) = "ca passe 2"
	| otherwise = "Go to college"
--3
getfirstIntem []  = "Empty String"
getfirstIntem all@(x:xs) = "the first letter in "++ all ++ " is " ++[x]
--4
times2 :: Int -> Int
times2 x = x * 2 
listeTimes2 = map times2 [1,2,3,4,5]
--5
doubleEvenNumber y =
		if (y `mod` 2 /= 0)
		then y
		else y*2
--6
getClass :: Int -> String
getClass n = case n of
	5 -> "Go to knmudrhfùoqierc"
	6 -> "go to room"
 --7
--data ShirtSize = S | M | L
--instance Eq ShirtSize where 
--	S == S = True
--	M == M = True
--	L == L = True
--	_ == _  = False
--instance Show ShirtSize where
--	show S = "Small"
--	show M = "Medium"
--	show L = "Large"
--smallAvail = S `elem` [S, M, L]
--theSize = show S--
--
class MyEq a where
	areEqual :: a -> a -> Bool
data ShirtSize1 = S | M | L
instance MyEq ShirtSize1 where 
	areEqual S S = True
	areEqual M M = True
	areEqual L L = True 
	areEqual _ _ = False
newSize = areEqual M M
--9
sayHello = do
	putStrLn "What's your name"
	name <- getLine
	putStrLn $ "hello" ++ name
writeToFile = do
		theFile <- openFile "test.txt" WriteMode
		hPutStrLn theFile ("Random line of text")
		hClose theFile
readFromFile = do
	theFile2 <- openFile " test.txt" ReadMode
	contents <- hGetContents theFile2
	putStr contents
	hClose theFile2
