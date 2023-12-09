#Окремий модуль що містить скрипт створення зубчастого масиву
def execute():
    size = int(input("Enter the size of the square matrix: "))
    filler = input("\nEnter the filler symbol: ")

    with open("arr.txt", "w") as fout:
        arr = [[' ' for _ in range(size)] for _ in range(size)]

        if len(filler) == 0:
            print("\nNo filler detected")
        elif len(filler) == 1:
            if size % 2 == 0:
                temp = 2
                for i in range(size // 2):
                    if temp < size:
                        arr[i] = [' ' for _ in range(temp)]
                        arr[size - i - 1] = [' ' for _ in range(temp)]
                        temp += 2
                    elif temp == size:
                        arr[i] = [' ' for _ in range(temp)]
                        arr[i + 1] = [' ' for _ in range(temp)]
            else:
                temp = 1
                for i in range((size - 1) // 2):
                    arr[i] = [' ' for _ in range(temp)]
                    arr[size - i - 1] = [' ' for _ in range(temp)]
                    temp += 2
                arr[(size - 1) // 2] = [' ' for _ in range(size)]

            for i in range(size):
                sub_len = len(arr[i])
                for _ in range(size - sub_len):
                    print(" ", end='')
                    fout.write(" ")
                for j in range(sub_len):
                    arr[i][j] = filler[0]
                    print(arr[i][j], end=' ')
                    fout.write(arr[i][j] + " ")
                print()
                fout.write("\n")
        else:
            print("\nToo many fillers detected")

        fout.flush()
